package alura.challenge6.domain.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAbrigo(
        @NotNull
        Long id,
        String nome,
        String localidade) {
}
