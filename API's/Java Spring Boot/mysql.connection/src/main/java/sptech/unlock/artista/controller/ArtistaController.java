package sptech.unlock.artista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.artista.model.Artista;
import sptech.unlock.artista.repositorio.RepositorioArtista;

@Controller
@RequestMapping("/artista")
public class ArtistaController {

    @Autowired
    private RepositorioArtista repositorioArtista;

    @PostMapping("/cadastrar")
    public @ResponseBody String cadastrar(
            @RequestBody Artista artista
    ) {
        repositorioArtista.save(artista);
        return String.format("%s cadastrado com sucesso!", artista);
    }

    @GetMapping("/logar")
    public @ResponseBody String logar(
            @RequestParam String email,
            @RequestParam String senha
    ) {
        for (int i = 0; i < repositorioArtista.findAll().size(); i++) {
            String emailDaVez = repositorioArtista.findAll().get(i).getEmail_artista();
            String senhaDaVez = repositorioArtista.findAll().get(i).getSenha_artista();
            if ( emailDaVez.equals(email) && senhaDaVez.equals(senha) ) {
                String nomeArtista = repositorioArtista.findAll().get(i).getNome_artista();

                //Print apenas para confirmar que foi encontrado o email e senha corretos!!!
                System.out.println(String.format("Logando Artista...\nEmail: %s\nSenha: %s\n", emailDaVez, senhaDaVez));

                return String.format("Bem-vindo %s, login realizado com sucesso!",
                        nomeArtista);
            }
        }
        return "E-mail e/ou senha inválido!";
    }
}
