package com.jprestes.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "registration")
@Schema(description = "Representa uma matrícula de aluno em curso")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @NotNull
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @NotBlank
    @Schema(description = "Status da matrícula, ex: ativo, concluído, cancelado")
    private String status;
}
