package alura.challenge6.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(
        @NotBlank(message = "O campo nome é obrigatório!")
        String nome,
        @NotBlank(message = "O campo email é obrigatório!")
        @Email(message = "Endereço de email inválido!")
        String email,
        @NotBlank(message = "O campo senha é obrigatório!")
        String senha
) {
}
