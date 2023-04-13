package alura.challenge6.controller;

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
    public ResponseEntity<Page<DadosListagemAbrigo>> listar(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(abrigoRepository.findAllByAtivoTrue(pageable).map(DadosListagemAbrigo::new));
    }
}
