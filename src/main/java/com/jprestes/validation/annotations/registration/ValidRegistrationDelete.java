package com.jprestes.validation.annotations.registration;

import com.jprestes.domain.dto.course.CourseDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Matrícula deletada com sucesso",
                content = @io.swagger.v3.oas.annotations.media.Content(
                        mediaType = "application/json",
                        schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CourseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Matrícula não encontrada",
                content = @io.swagger.v3.oas.annotations.media.Content(
                        mediaType = "application/json",
                        schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CourseDTO.class)))
})
public @interface ValidRegistrationDelete {
}
