package alura.challenge6.domain.dto;

import alura.challenge6.domain.model.Abrigo;

public record DadosListagemAbrigo(Long id, String nome, String localidade) {
    public DadosListagemAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getLocalidade());
    }
}
