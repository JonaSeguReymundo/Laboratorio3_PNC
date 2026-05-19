package com.example.api_specimen.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueSpecimenNameValidator.class)
@Documented
public @interface UniqueSpecimenName {
    String message() default "Specimen name must be unique in Hyrule records.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}