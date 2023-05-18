package com.example.vans_back.business.login;

import com.example.vans_back.domain.user.User;
import com.example.vans_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    public void login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);

    }
}
