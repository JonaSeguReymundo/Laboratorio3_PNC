package com.example.api_specimen.domain.dto.request;

import com.example.api_specimen.common.validation.UniqueSpecimenName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSpecimenRequest {
    @NotBlank(message = "The specimen name cannot be empty.")
    @UniqueSpecimenName()
    private String name;

    @NotBlank(message = "The region of Hyrule must be specified.")
    private String region;

    @NotNull(message = "Danger level is required.")
    private Integer dangerLevel;

    @NotNull(message = "You must specify if the specimen is friendly.")
    private Boolean isFriendly;
}