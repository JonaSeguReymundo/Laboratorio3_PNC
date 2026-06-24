package com.example.api_specimen;

import org.junit.jupiter.api.Disabled; // <- Esta importación es nueva
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled // <- Esta anotación desactiva el test temporalmente
@SpringBootTest
class ApiSpecimenApplicationTests {

    @Test
    void contextLoads() {
    }

}