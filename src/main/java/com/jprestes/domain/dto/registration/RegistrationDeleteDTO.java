package com.jprestes.domain.dto.registration;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "RegistrationDelete", description = "Estrutura de dados para a exclusão de matrícula")
public class RegistrationDeleteDTO {
    private Long courseId;
}
