package alura.challenge6.controller;

import alura.challenge6.domain.dto.DadosCadastroTutor;
import alura.challenge6.domain.dto.DadosDetalhamentoTutor;
import alura.challenge6.domain.model.Tutor;
import alura.challenge6.repository.TutorRepository;
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
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados){
        var tutor = new Tutor(dados);
        tutorRepository.save(tutor);

        return ResponseEntity.ok(new DadosDetalhamentoTutor(tutor));
    }

    @GetMapping
    public ResponseEntity<Page<Tutor>> listar(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(tutorRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        if(!tutorRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutor não encontrado!");
        }
        var tutor = tutorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTutor(tutor));
    }
}
