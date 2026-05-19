package com.example.api_specimen.common.validation;

import com.example.api_specimen.repositories.SpecimenRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueSpecimenNameValidator implements ConstraintValidator<UniqueSpecimenName, String> {

    private final SpecimenRepository specimenRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        return !specimenRepository.existsByName(value);
    }
}
