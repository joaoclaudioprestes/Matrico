package com.jprestes.validation.annotations;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Operation(summary = "Atualiza um curso pelo ID.")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso.",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização.",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Curso não encontrado.",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor.",
                content = @Content)
})

public @interface ValidCourseUpdate {
}
