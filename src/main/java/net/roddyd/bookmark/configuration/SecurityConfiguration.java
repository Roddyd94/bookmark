package net.roddyd.bookmark.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private Environment env;
    private static String CLIENT_PROPERTY_KEY
            = "spring.security.oauth2.client.registration.";
    private static List<String> clients = Arrays.asList("google", "github");

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/user").authenticated()
                    .anyRequest().permitAll())
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
            .logout(logout -> logout
                .logoutSuccessUrl("/login.html").permitAll())
            .oauth2Login()
                .loginPage("/login.html").and()
            .csrf()
                .disable()
            .headers()
                .xssProtection().and()
                .referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.NO_REFERRER_WHEN_DOWNGRADE).and()
                .contentSecurityPolicy("" +
                        "connect-src 'self' https://accounts.google.com/gsi/; " +
                        "frame-src 'self' https://accounts.google.com/gsi/; " +
                        "script-src 'self' https://accounts.google.com/gsi/client;");

        return http.build();
    }
}
