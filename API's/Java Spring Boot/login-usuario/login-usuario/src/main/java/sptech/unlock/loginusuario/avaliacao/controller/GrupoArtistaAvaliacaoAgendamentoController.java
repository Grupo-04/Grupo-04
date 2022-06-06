package sptech.unlock.loginusuario.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.entidade.GrupoArtistaAvaliacaoAgendamento;
import sptech.unlock.loginusuario.avaliacao.repositorio.RepositorioGrupoArtistaAvaliacaoAgendamento;
import sptech.unlock.loginusuario.interfaces.Avaliavel;
import sptech.unlock.loginusuario.pilhaobj.PilhaObj;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (Objects.isNull(id)){
            return ResponseEntity.status(400).build();
        }
        if (Objects.isNull(avaliacao)){
            return ResponseEntity.status(400).build();
        }

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

    public PilhaObj<GrupoArtistaAvaliacaoAgendamento> empilharAvaliacao(List<GrupoArtistaAvaliacaoAgendamento> listaGrupoArtistaAvaliacaoAgendamento) {
        PilhaObj<GrupoArtistaAvaliacaoAgendamento> pilhaGrupoArtistaAvaliacaoAgendamento = new PilhaObj<>(listaGrupoArtistaAvaliacaoAgendamento.size());

        for (int i = 0; i < listaGrupoArtistaAvaliacaoAgendamento.size(); i++) {
            pilhaGrupoArtistaAvaliacaoAgendamento.push(listaGrupoArtistaAvaliacaoAgendamento.get(i));
        }

        return pilhaGrupoArtistaAvaliacaoAgendamento;
    }

    @GetMapping("/empilhar")
    public ResponseEntity getPilhaGrupoArtistaAvaliacaoAtendimento() {
        if (empilharAvaliacao(repository.findAll()).isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(empilharAvaliacao(repository.findAll()));
        }
    }

    @GetMapping("/ultimo-empilhado")
    public ResponseEntity getUltimoEmpilhado(){
        if (empilharAvaliacao(repository.findAll()).isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(empilharAvaliacao(repository.findAll()).peek());
        }
    }

}
