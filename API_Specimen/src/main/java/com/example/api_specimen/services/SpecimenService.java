package com.example.api_specimen.services;

import com.example.api_specimen.domain.dto.request.CreateSpecimenRequest;
import com.example.api_specimen.domain.dto.request.UpdateSpecimenRequest;
import com.example.api_specimen.domain.dto.response.PageableResponse;
import com.example.api_specimen.domain.dto.response.SpecimenResponse;

import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);
    PageableResponse<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder);
    SpecimenResponse getSpecimenById(UUID id);
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);
    SpecimenResponse deleteSpecimen(UUID id);
}