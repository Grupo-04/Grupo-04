package sptech.unlock.loginusuario.grupoArtista.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.repositorio.RepositorioGrupoArtista;
import sptech.unlock.loginusuario.interfaces.Autenticavel;
import sptech.unlock.loginusuario.interfaces.Registravel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/grupo-artista")
public class GrupoArtistaController implements Registravel<ResponseEntity, GrupoArtista>, Autenticavel {

    @Autowired
    private RepositorioGrupoArtista grupoArtistas;

    @PostMapping
    @Override
    public ResponseEntity cadastrar(@RequestBody GrupoArtista grupoArtista) {
        grupoArtistas.save(grupoArtista);
        return ResponseEntity.status(201).body(grupoArtista);
    }

    @GetMapping("/listar")
    @Override
    public ResponseEntity exibirTodos() {
        return ResponseEntity.status(200).body(grupoArtistas.findAll());
    }

    @GetMapping
    @Override
    public ResponseEntity login(
            @RequestParam String email,
            @RequestParam String senha
    ) {

        for (GrupoArtista grup : grupoArtistas.findAll()){
            if (grup.getEmail().equals(email) && grup.getSenha().equals(senha)){
                grup.setAutenticado(true);
                return ResponseEntity.status(202).build();
            }
        }
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping
    @Override
    public ResponseEntity logoff(
            @RequestParam String email,
            @RequestParam String senha
    ) {

        for (GrupoArtista grup : grupoArtistas.findAll()){
            if (grup.getEmail().equals(email) && grup.getSenha().equals(senha)){
                grup.setAutenticado(false);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(200).build();
    }

}
