package com.example.api_specimen.repositories;

import com.example.api_specimen.domain.entities.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen, UUID> {
    // Consulta personalizada para verificar duplicados por nombre
    boolean existsByName(String name);
}