package com.jprestes.domain.dto.student;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "StudentCreate", description = "Estrutura de dados para a criação de aluno")
public class StudentCreateDTO {
    private String name;
    private String email;
}
