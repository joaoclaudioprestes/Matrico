package com.jprestes.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
@Schema(name = "Course", description = "Representa um curso oferecido")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do curso", example = "1")
    private Long id;

    @NotBlank
    @Column(nullable = false)
    @Schema(description = "Nome do curso", example = "Programação Java")
    private String name;

    @NotBlank
    @Column(nullable = false)
    @Schema(description = "Descrição do curso", example = "Curso introdutório de Java para iniciantes")
    private String description;
}
