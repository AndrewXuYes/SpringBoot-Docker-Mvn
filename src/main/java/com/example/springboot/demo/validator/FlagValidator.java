package com.example.springboot.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义验证
 * Created by macro on 2018/4/26.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)// 注解将会由虚拟机保留,以便它可以在运行时通过反射读取.
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    String[] value() default {};

    String message() default "flag is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
