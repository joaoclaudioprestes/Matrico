package com.jprestes.validation.annotations.course;

import com.jprestes.domain.dto.ApiErrorDTO;
import com.jprestes.domain.dto.course.CourseDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de cursos retornada com sucesso.",
                content = @io.swagger.v3.oas.annotations.media.Content(
                        mediaType = "application/json",
                        schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CourseDTO.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor.",
                content = @io.swagger.v3.oas.annotations.media.Content(
                        mediaType = "application/json",
                        schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiErrorDTO.class)))
})
public @interface ValidCourseList {
}
