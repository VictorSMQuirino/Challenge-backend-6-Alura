package alura.challenge6.domain.model;

import alura.challenge6.domain.dto.DadosAtualizacaoTutor;
import alura.challenge6.domain.dto.DadosCadastroTutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Tutor")
@Table(name = "tutores")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tutor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    private Boolean ativo;

    public Tutor(DadosCadastroTutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoTutor dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.senha() != null){
            this.senha = dados.senha();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
