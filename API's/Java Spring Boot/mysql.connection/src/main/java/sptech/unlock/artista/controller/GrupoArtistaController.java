package sptech.unlock.artista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sptech.unlock.artista.model.GrupoArtista;
import sptech.unlock.artista.repositorio.RepositorioGrupoArtista;
import sptech.unlock.endereco.model.Endereco;

@Controller
@RequestMapping("/grupoArtistas")
public class GrupoArtistaController {

    @Autowired
    private RepositorioGrupoArtista grupoArtistas;

    @PostMapping("/cadastrar")
    public @ResponseBody
    String cadastrarGrupoArtista(@RequestBody GrupoArtista grupoArtista) {
        grupoArtistas.save(grupoArtista);
        return String.format("Endereco %s cadastrado com sucesso!", grupoArtista);
    }
}
