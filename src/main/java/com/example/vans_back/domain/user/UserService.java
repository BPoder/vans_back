package com.example.vans_back.domain.user;

import com.example.vans_back.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public void findUserBy(String username, String password) {
        userRepository.findUserBy(username, password, Status.ACTIVE.getLetter());
        return ;
    }
}
