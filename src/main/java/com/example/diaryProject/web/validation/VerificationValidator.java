package com.example.diaryProject.web.validation;

import com.example.diaryProject.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@AllArgsConstructor
public class VerificationValidator implements ConstraintValidator<Verification,Object> {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private String[] fields;

    public void initialize(Verification annotation) {
        this.fields = annotation.fields();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        String  name = (String)beanWrapper.getPropertyValue(fields[0]);
        String password = (String)beanWrapper.getPropertyValue(fields[1]);
        if(encoder.matches(password,repository.getPassword(name))){
            return true;
        }
        return false;
    }
}



