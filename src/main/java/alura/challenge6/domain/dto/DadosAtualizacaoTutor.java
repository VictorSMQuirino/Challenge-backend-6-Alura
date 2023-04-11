package alura.challenge6.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTutor(
        @NotNull
        Long id,
        String nome,
        @Email(message = "Endereço de email inválido!")
        String email,
        String senha) {
}
