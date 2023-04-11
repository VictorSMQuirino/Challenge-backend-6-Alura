package alura.challenge6.domain.dto;

import alura.challenge6.domain.model.Tutor;

public record DadosDetalhamentoTutor(Long id, String nome, String email) {

    public DadosDetalhamentoTutor(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }
}
