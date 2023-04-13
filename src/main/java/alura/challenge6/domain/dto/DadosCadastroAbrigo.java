package alura.challenge6.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAbrigo(
        @NotBlank(message = "Campo nome é obrigatório")
        String nome,
        @NotBlank(message = "Campo localidade é obrigatório")
        String localidade) {
}
