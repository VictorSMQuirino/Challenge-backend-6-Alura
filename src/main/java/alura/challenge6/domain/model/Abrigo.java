package alura.challenge6.domain.model;

import alura.challenge6.domain.dto.DadosAtualizacaoAbrigo;
import alura.challenge6.domain.dto.DadosCadastroAbrigo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Abrigo")
@Table(name = "abrigos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Abrigo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String localidade;
    private Boolean ativo;

    public Abrigo(DadosCadastroAbrigo dados) {
        this.nome = dados.nome();
        this.localidade = dados.localidade();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizacaoAbrigo dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.localidade() != null){
            this.localidade = dados.localidade();
        }
    }
}
