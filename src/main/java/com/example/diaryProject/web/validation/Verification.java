package com.example.diaryProject.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VerificationValidator.class)
public @interface Verification {
    String message() default "ユーザー名またはパスワードが異なります";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    // チェックする値を格納
    String[] fields();
}