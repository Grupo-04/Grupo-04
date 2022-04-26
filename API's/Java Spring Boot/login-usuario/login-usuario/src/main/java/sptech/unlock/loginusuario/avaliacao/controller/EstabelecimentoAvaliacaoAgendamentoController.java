package sptech.unlock.loginusuario.avaliacao.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.repositorio.RepositorioEstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.interfaces.Avaliavel;

@RestController
@RequestMapping("/estabelecimento-avaliacao")
public class EstabelecimentoAvaliacaoAgendamentoController implements Avaliavel<ResponseEntity,EstabelecimentoAvaliacaoAgendamento> {

    @Autowired
    private RepositorioEstabelecimentoAvaliacaoAgendamento repository;

    @GetMapping
    public ResponseEntity getAvaliacaoEstabelecimento(){
        if (repository.findAll().size() < 1){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PostMapping
    @Override
    public ResponseEntity avaliar(@RequestBody EstabelecimentoAvaliacaoAgendamento avaliacao){
        repository.save(avaliacao);
        return ResponseEntity.status(201).body(avaliacao);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity atualizar(
            @PathVariable Integer id,
            @RequestBody EstabelecimentoAvaliacaoAgendamento avaliacao
    ){
        if(repository.existsById(id)){
            avaliacao.setId(id);
            repository.save(avaliacao);
            return ResponseEntity.status(200).body(avaliacao);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity atualizar(
            @PathVariable Integer id
    ){
        for (EstabelecimentoAvaliacaoAgendamento estab : repository.findAll()){
            if (estab.getFk_agendamento().equals(id)){
                repository.delete(estab);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(204).build();
    }

}
