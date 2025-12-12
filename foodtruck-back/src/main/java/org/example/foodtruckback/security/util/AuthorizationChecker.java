package org.example.foodtruckback.security.util;

import lombok.RequiredArgsConstructor;
import org.example.foodtruckback.entity.user.User;
import org.example.foodtruckback.repository.user.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("authz")
public class AuthorizationChecker {
    private final UserRepository userRepository;

    public boolean isUserAuthor(String loginId, Authentication principal) {
        if (loginId == null || principal == null) return false;

        String login = principal.getName();

        User user = userRepository.findByLoginId(loginId).orElse(null);

        if (user == null) return false;

        return user.getLoginId().equals(loginId);
    }
}
