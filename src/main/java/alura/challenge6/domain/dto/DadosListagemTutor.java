package alura.challenge6.domain.dto;

import alura.challenge6.domain.model.Tutor;

public record DadosListagemTutor(Long id, String nome, String email) {

    public DadosListagemTutor(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }
}
