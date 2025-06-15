package com.jprestes.domain.dto.registration;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "RegistrationCreate", description = "Estrtura de dados para a criação de matrícula")
public class RegistrationCreateDTO {
    private Long courseId;
    private Long studentId;
}
