package sptech.unlock.loginusuario.disponibilidade.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeGrupoArtista;
import sptech.unlock.loginusuario.disponibilidade.repositorio.RepositorioDisponibilidadeGrupoArtista;

import java.util.Objects;

@RestController
@RequestMapping(path = "/disponibilidade-grupo-artista")
public class DisponibilidadeGrupoArtistaController {

    @Autowired
    private RepositorioDisponibilidadeGrupoArtista repository;

    @PostMapping("/{id}")
    public ResponseEntity postDisponibilidade(@RequestBody DisponibilidadeGrupoArtista disponibilidade, @PathVariable int id) {
        if (Objects.isNull(disponibilidade)) {
            return ResponseEntity.status(204).build();
        }

        disponibilidade.setFk_grupo_artista(id);
        repository.save(disponibilidade);
        return ResponseEntity.status(201).body(disponibilidade);
    }
}
