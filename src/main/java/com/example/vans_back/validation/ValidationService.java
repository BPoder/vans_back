package com.example.vans_back.validation;

import com.example.vans_back.domain.user.User;
import com.example.vans_back.infrastructure.exception.BusinessException;

import java.util.Optional;

import static com.example.vans_back.validation.Error.INCORRECT_CREDENTIALS;

public class ValidationService {
    public static void validateCorrectLoginCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
    }
}
