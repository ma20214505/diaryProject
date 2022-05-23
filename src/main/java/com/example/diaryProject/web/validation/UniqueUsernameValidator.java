package com.example.diaryProject.web.validation;

import javax.validation.ConstraintValidator;

import com.example.diaryProject.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepository.findByUsername(value).isEmpty();
    }
}