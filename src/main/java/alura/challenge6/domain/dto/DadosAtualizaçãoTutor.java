package alura.challenge6.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaçãoTutor(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        String senha) {
}
