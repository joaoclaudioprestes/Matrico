package com.jprestes.domain.dto.course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CourseCreate", description = "Estrutura de dados para criação de curso")
public class CourseCreateDTO {
    private String name;
    private String description;
}
