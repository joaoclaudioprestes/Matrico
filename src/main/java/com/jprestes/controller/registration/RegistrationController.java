package com.jprestes.controller.registration;

import com.jprestes.domain.dto.ApiResponseDTO;
import com.jprestes.domain.dto.registration.RegistrationCreateDTO;
import com.jprestes.domain.dto.registration.RegistrationDeleteDTO;
import com.jprestes.domain.entity.Registration;
import com.jprestes.service.RegistrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Tag(name = "Registration", description = "Operações relacionadas à matrícula de alunos")
@RestController
@RequestMapping("/matriculas")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<RegistrationCreateDTO>> createRegistration(@Valid @RequestBody RegistrationCreateDTO createDTO) {

        Registration registration = registrationService.createRegistration(createDTO);

        ApiResponseDTO<RegistrationCreateDTO> response = new ApiResponseDTO<>(true, "Matrícula criada com sucesso", createDTO);

        return ResponseEntity.created(URI.create("/matriculas/" + registration.getId())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<RegistrationDeleteDTO>> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);

        return ResponseEntity.noContent().build();
    }
}
