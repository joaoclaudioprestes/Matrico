package com.jprestes.domain.dto.student;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "StudentUpdate", description = "Estrutura de dados para atualização de aluno")
public class StudentUpdateDTO {
    private String name;
    private String email;
}
