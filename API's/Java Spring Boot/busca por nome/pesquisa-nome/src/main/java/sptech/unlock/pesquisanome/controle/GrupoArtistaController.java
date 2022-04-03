package sptech.unlock.pesquisanome.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.pesquisanome.entidade.GrupoArtista;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/grupo_artista")
public class GrupoArtistaController {

    private List<GrupoArtista> grupoArtistas = new ArrayList<>();

    @PostMapping
    public ResponseEntity cadastrarArtista(@RequestBody GrupoArtista artistas){
        grupoArtistas.add(artistas);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{nomeArtista}")
    public ResponseEntity buscarArtista(@PathVariable String nomeArtista){
        for (GrupoArtista artista : grupoArtistas){
            if(nomeArtista.equals(artista.getNome_artistico())){
                return ResponseEntity.status(201).body(artista);
            }
        }
        return ResponseEntity.status(404).build();
    }
}
