package com.jprestes.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Student", description = "Estrutura de dados para o aluno")
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
}
