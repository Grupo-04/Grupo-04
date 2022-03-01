package sptech.unlock.artista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sptech.unlock.artista.model.Artista;
import sptech.unlock.artista.repositorio.RepositorioArtista;

@Controller
@RequestMapping("/artista")
public class ArtistaController {

    @Autowired
    private RepositorioArtista repositorioArtista;

    @PostMapping("/cadastrar")
    public @ResponseBody String cadastrarArtista(
            @RequestBody Artista artista
    ) {
        repositorioArtista.save(artista);
        return String.format("%s cadastrado com sucesso!", artista);
    }
}
