package sptech.unlock.artista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.artista.model.Artista;
import sptech.unlock.artista.repositorio.RepositorioArtista;

import java.util.List;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private RepositorioArtista repositorioArtista;

    @PostMapping //("/cadastrar")
    public @ResponseBody String cadastrar(
            @RequestBody Artista artista
    ) {
        repositorioArtista.save(artista);
        return String.format("Usuário %s cadastrado com sucesso!", artista.getNome_artista());
    }

    @GetMapping //("/login")
    public @ResponseBody String logar(
            @RequestParam String email,
            @RequestParam String senha
    ) {
        for (Artista artista : repositorioArtista.findAll()) {
            if (artista.getEmail_artista().equals(email) && artista.getSenha_artista().equals(senha)) {
                artista.setAutenticado(true);
                repositorioArtista.save(artista); //salvando alterações do artista
                return String.format("Login  de usuário %s realizado com sucesso!", artista.getNome_artista());
            }
        }
        return "E-mail e/ou senha inválido!";
    }

    @DeleteMapping //("/logoff")
    public @ResponseBody
    String logoff(
            @RequestParam String email,
            @RequestParam String senha
    ) {
        for (Artista artista : repositorioArtista.findAll()) {
            if (artista.getEmail_artista().equals(email) && artista.getSenha_artista().equals(senha)) {
                artista.setAutenticado(false);
                repositorioArtista.save(artista); //salvando alterações do artista
                return String.format("Logoff  de usuário %s realizado com sucesso!", artista.getNome_artista());
            }
        }
        return String.format("Usuário de e-mail %s não encontrado!", email);
    }

    @GetMapping("/listar")
    public @ResponseBody
    List<Artista> listar() {
        return repositorioArtista.findAll();
    }
}
