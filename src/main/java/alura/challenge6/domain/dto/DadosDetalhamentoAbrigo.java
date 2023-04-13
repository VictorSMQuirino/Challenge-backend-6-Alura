package alura.challenge6.domain.dto;

import alura.challenge6.domain.model.Abrigo;

public record DadosDetalhamentoAbrigo(Long id, String nome, String localidade) {
    public DadosDetalhamentoAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getLocalidade());
    }
}
