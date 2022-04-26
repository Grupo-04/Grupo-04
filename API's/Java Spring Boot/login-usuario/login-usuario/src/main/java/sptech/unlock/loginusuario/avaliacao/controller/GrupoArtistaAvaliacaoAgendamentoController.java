package sptech.unlock.loginusuario.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.entidade.GrupoArtistaAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.repositorio.RepositorioGrupoArtistaAvaliacaoAgendamento;
import sptech.unlock.loginusuario.interfaces.Avaliavel;

@RestController
@RequestMapping("/grupo-artista-avaliacao")
public class GrupoArtistaAvaliacaoAgendamentoController implements Avaliavel<ResponseEntity, GrupoArtistaAvaliacaoAgendamento> {

    @Autowired
    private RepositorioGrupoArtistaAvaliacaoAgendamento repository;

    @GetMapping
    public ResponseEntity getAvaliacaoEstabelecimento(){
        if (repository.findAll().size() < 1){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PostMapping
    @Override
    public ResponseEntity avaliar(@RequestBody GrupoArtistaAvaliacaoAgendamento avaliacao){
        repository.save(avaliacao);
        return ResponseEntity.status(201).body(avaliacao);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity atualizar(
            @PathVariable Integer id,
            @RequestBody GrupoArtistaAvaliacaoAgendamento avaliacao
    ){
        if(repository.existsById(id)){
            avaliacao.setId(id);
            repository.save(avaliacao);
            return ResponseEntity.status(200).body(avaliacao);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAvaliacaoGrupoArtista(
            @PathVariable Integer id
    ){
        for (GrupoArtistaAvaliacaoAgendamento grupoArtista : repository.findAll()) {
            if (grupoArtista.getFk_agendamento().equals(id)) {
                repository.delete(grupoArtista);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(204).build();
    }

}
