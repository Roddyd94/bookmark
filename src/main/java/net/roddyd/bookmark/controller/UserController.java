package net.roddyd.bookmark.controller;

import io.netty.util.internal.StringUtil;
import jakarta.servlet.http.HttpSession;
import net.roddyd.bookmark.entity.User;
import net.roddyd.bookmark.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(path = "/login")
    public Object login(HttpSession session, @AuthenticationPrincipal OAuth2User principal) throws Exception {
        if (principal == null) return Collections.singletonMap("code", 400);

        String email = principal.getAttribute("email");
        String sub = principal.getAttribute("sub");
        User user = userService.login(sub, email);

        session.setAttribute("id", user.getId());

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 200);
        result.put("name", StringUtil.isNullOrEmpty(user.getNickname()) ? principal.getAttribute("name") : user.getNickname());

        return result;
    }
}
