package com.jprestes.domain.dto.course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CourseUpdate", description = "Estrutura de dados para atualização de curso")
public class CourseUpdateDTO {
    private String name;
    private String description;
}
