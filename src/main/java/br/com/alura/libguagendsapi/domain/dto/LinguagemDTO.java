package br.com.alura.libguagendsapi.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LinguagemDTO(
        @NotBlank
        String title,
        @NotBlank
        String image,
        @NotNull
        Integer ranking) {
}
