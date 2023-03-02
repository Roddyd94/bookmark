package net.roddyd.bookmark.service;

import net.roddyd.bookmark.entity.OAuth2;
import net.roddyd.bookmark.entity.OAuth2Id;
import net.roddyd.bookmark.entity.User;
import net.roddyd.bookmark.repository.OAuth2Repository;
import net.roddyd.bookmark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OAuth2Repository oAuth2Repository;

    public User login(String sub, String email) throws Exception {
        List<OAuth2> OAuth2s = oAuth2Repository.findByIdSub(sub);
        User user = null;

        if (OAuth2s.isEmpty()) user = this.register(sub, email);
        else user = OAuth2s.get(0).getId().getUser();

        if (user == null) user = this.register(sub, email);
        else userRepository.save(user);

        return user;
    }

    private User register(String sub, String email) {
        User user = new User();
        user = userRepository.save(user);
        OAuth2 oAuth2 = OAuth2.builder()
                .id(new OAuth2Id(user, sub))
                .email(email).build();

        oAuth2Repository.save(oAuth2);
        return user;
    }

    protected void create(User user) {
        userRepository.save(user);
    }
}
