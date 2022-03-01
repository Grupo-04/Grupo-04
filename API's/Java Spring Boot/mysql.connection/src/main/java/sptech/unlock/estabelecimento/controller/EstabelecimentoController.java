package sptech.unlock.estabelecimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.estabelecimento.model.Estabelecimento;

@Controller
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    private RepositorioEstabelecimento repositorioEstabelecimento;

    @PostMapping("/cadastrar")
    public @ResponseBody String cadastrar(
            @RequestBody Estabelecimento estabelecimento
    ) {
        repositorioEstabelecimento.save(estabelecimento);
        return String.format("%s Cadastrado com sucesso!", estabelecimento);
    }

    @GetMapping("/logar")
    public @ResponseBody String logar(
            @RequestParam String email,
            @RequestParam String senha
    ) {
        for (int i = 0; i < repositorioEstabelecimento.findAll().size(); i++) {
            String emailDaVez = repositorioEstabelecimento.findAll().get(i).getEmail_estabelecimento();
            String senhaDaVez = repositorioEstabelecimento.findAll().get(i).getSenha_estabelecimento();
            if ( emailDaVez.equals(email) && senhaDaVez.equals(senha) ) {
                String nomeEstabelecimento = repositorioEstabelecimento.findAll().get(i).getNome_estabelecimento();

                //Print apenas para confirmar que foi encontrado o email e senha corretos!!!
                System.out.println(String.format("Logando Estabelecimento...\nEmail: %s\nSenha: %s\n", emailDaVez, senhaDaVez));

                return String.format("Bem-vindo %s, login realizado com sucesso!",
                        nomeEstabelecimento);
            }
        }
        return "E-mail e/ou senha inválido!";
    }
}
