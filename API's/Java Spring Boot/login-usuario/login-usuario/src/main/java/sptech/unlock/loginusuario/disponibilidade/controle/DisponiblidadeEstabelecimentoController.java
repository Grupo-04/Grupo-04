package sptech.unlock.loginusuario.disponibilidade.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeEstabelecimento;
import sptech.unlock.loginusuario.disponibilidade.repositorio.RepositorioDisponibilidadeEstabelecimento;

@RestController
@RequestMapping(path = "/disponibilidade-estabelecimento")
public class DisponiblidadeEstabelecimentoController {

    @Autowired
    private RepositorioDisponibilidadeEstabelecimento repository;

    @PostMapping("/{id}")
    public ResponseEntity postDisponibilidade(@RequestBody DisponibilidadeEstabelecimento disponibilidade, @PathVariable Integer id){
        disponibilidade.setFk_estabelecimento(id);
        repository.save(disponibilidade);
        return ResponseEntity.status(201).body(disponibilidade);
    }
}
