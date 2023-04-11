package alura.challenge6.controller;

import alura.challenge6.domain.dto.DadosCadastroTutor;
import alura.challenge6.domain.dto.DadosDetalhamentoTutor;
import alura.challenge6.domain.model.Tutor;
import alura.challenge6.repository.TutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
