package com.jprestes.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Course", description = "Estrutura de dados para o curso")
public class CourseDTO {
    private String name;
    private String description;
}
