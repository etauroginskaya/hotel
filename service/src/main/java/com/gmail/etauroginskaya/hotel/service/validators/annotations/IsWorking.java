package com.gmail.etauroginskaya.hotel.service.validators.annotations;

import com.gmail.etauroginskaya.hotel.service.validators.DaysIsWorkingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DaysIsWorkingValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsWorking {
    String message() default "selected off day";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
