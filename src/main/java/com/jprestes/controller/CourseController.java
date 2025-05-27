package com.jprestes.controller;

import com.jprestes.domain.dtos.CourseDTO;
import com.jprestes.domain.dtos.ErrorResponseDTO;
import com.jprestes.domain.entity.Course;
import com.jprestes.exceptions.CourseValidationException;
import com.jprestes.exceptions.ErrorResponseException;
import com.jprestes.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um curso.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso criado com sucesso.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro de validação. Nome e descrição do curso são obrigatórios.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    public Course createCourse(@RequestBody CourseDTO course) {

        if (course.getName() == null || course.getName().trim().isEmpty() ||
                course.getDescription() == null || course.getDescription().trim().isEmpty()) {
            throw new CourseValidationException("Nome e descrição do curso são obrigatórios.");
        }

        Course courseEntity = new Course();
        courseEntity.setName(course.getName());
        courseEntity.setDescription(course.getDescription());

        try {
            return courseService.createCourse(courseEntity);
        } catch (Exception e) {
            throw new ErrorResponseException("Erro ao criar curso: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
