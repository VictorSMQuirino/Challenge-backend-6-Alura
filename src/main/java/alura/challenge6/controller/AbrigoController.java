package alura.challenge6.controller;

import alura.challenge6.domain.dto.DadosAtualizacaoAbrigo;
import alura.challenge6.domain.dto.DadosCadastroAbrigo;
import alura.challenge6.domain.dto.DadosDetalhamentoAbrigo;
import alura.challenge6.domain.dto.DadosListagemAbrigo;
import alura.challenge6.domain.model.Abrigo;
import alura.challenge6.repository.AbrigoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAbrigo dados){
        var abrigo = new Abrigo(dados);
        abrigoRepository.save(abrigo);

        return ResponseEntity.status(HttpStatus.OK).body(new DadosDetalhamentoAbrigo(abrigo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAbrigo>> listar(@PageableDefault(size = 10, sort = "id") Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(abrigoRepository.findAllByAtivoTrue(pageable).map(DadosListagemAbrigo::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        if(!abrigoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abrigo não encontrado!");
        }
        var abrigo = abrigoRepository.getReferenceById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new DadosDetalhamentoAbrigo(abrigo));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAbrigo dados){
        var abrigo = abrigoRepository.getReferenceById(dados.id());
        abrigo.atualizar(dados);

        return ResponseEntity.status(HttpStatus.OK).body(new DadosDetalhamentoAbrigo(abrigo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        if(!abrigoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abrigo não encontrado!");
        }
        var abrigo = abrigoRepository.getReferenceById(id);
        abrigo.excluir();

        return ResponseEntity.status(HttpStatus.OK).body(new DadosDetalhamentoAbrigo(abrigo));
    }
}
