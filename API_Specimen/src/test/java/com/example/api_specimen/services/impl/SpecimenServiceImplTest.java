package com.example.api_specimen.services.impl;

import com.example.api_specimen.common.mappers.SpecimenMapper;
import com.example.api_specimen.domain.dto.request.CreateSpecimenRequest;
import com.example.api_specimen.domain.dto.response.SpecimenResponse;
import com.example.api_specimen.domain.entities.Specimen;
import com.example.api_specimen.repositories.SpecimenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecimenServiceImplTest {

    @Mock
    private SpecimenRepository specimenRepository;

    @Mock
    private SpecimenMapper specimenMapper;

    @InjectMocks
    private SpecimenServiceImpl specimenService;

    private CreateSpecimenRequest mockRequest;
    private Specimen mockEntity;
    private SpecimenResponse mockResponse;
    private UUID generatedId;

    @BeforeEach
    void setUp() {
        generatedId = UUID.randomUUID();

        mockRequest = new CreateSpecimenRequest();
        mockRequest.setName("Rupee Ore");

        mockEntity = new Specimen();
        mockEntity.setId(generatedId);
        mockEntity.setName("Rupee Ore");

        mockResponse = SpecimenResponse.builder()
                .id(generatedId)
                .name("Rupee Ore")
                .build();
    }

    @Test
    void createSpecimen_shouldSaveAndReturnResponse_whenRequestIsValid() {
        // Enlaza exactamente los métodos de SpecimenMapper y SpecimenRepository
        when(specimenMapper.toEntityCreate(mockRequest)).thenReturn(mockEntity);
        when(specimenRepository.save(mockEntity)).thenReturn(mockEntity);
        when(specimenMapper.toDto(mockEntity)).thenReturn(mockResponse);

        // Ejecución
        SpecimenResponse result = specimenService.createSpecimen(mockRequest);

        // Aserciones reales
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(generatedId);
        assertThat(result.getName()).isEqualTo("Rupee Ore");

        // Verificaciones de comportamiento obligatorias
        verify(specimenMapper, times(1)).toEntityCreate(mockRequest);
        verify(specimenRepository, times(1)).save(mockEntity);
        verify(specimenMapper, times(1)).toDto(mockEntity);
    }

    @Test
    void getSpecimenById_shouldReturnSpecimen_whenExists() {
        // Para probar el método getSpecimenById
        when(specimenRepository.findById(generatedId)).thenReturn(Optional.of(mockEntity));
        when(specimenMapper.toDto(mockEntity)).thenReturn(mockResponse);

        SpecimenResponse result = specimenService.getSpecimenById(generatedId);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(generatedId);
        verify(specimenRepository, times(1)).findById(generatedId);
    }
}