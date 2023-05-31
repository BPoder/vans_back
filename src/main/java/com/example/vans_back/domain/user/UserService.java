package com.example.vans_back.domain.user;

import com.example.vans_back.business.Status;
import com.example.vans_back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> userOptional = userRepository.findUserBy(username, password, Status.ACTIVE.getLetter());
        ValidationService.validateCorrectLoginCredentials(userOptional);
        User user = userOptional.get();
        return user;
    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserBy(Integer userId) {
        return userRepository.findById(userId).get();
    }
}
