package com.jprestes.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Schema(name = "Error Response", description = "Estrutura de dados para erros na API")
public class ErrorResponseDTO {
    private String message;
    private int status;
}