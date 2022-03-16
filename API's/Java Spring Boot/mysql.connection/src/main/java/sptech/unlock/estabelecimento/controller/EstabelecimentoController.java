package sptech.unlock.estabelecimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.estabelecimento.model.Estabelecimento;

import java.util.List;

@Controller
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

    @Autowired
    private RepositorioEstabelecimento repositorioEstabelecimento;

    @PostMapping //("/cadastrar")
    public @ResponseBody String cadastrar(
            @RequestBody Estabelecimento estabelecimento
    ) {
        repositorioEstabelecimento.save(estabelecimento);
        return String.format("Usuário %s cadastrado com sucesso!", estabelecimento.getNome_estabelecimento());
    }

    @GetMapping //("/login")
    public @ResponseBody
    String logar(
            @RequestParam String email,
            @RequestParam String senha
    ) {
        for (Estabelecimento estabelecimento : repositorioEstabelecimento.findAll()) {
            if (estabelecimento.getEmail_estabelecimento().equals(email) && estabelecimento.getSenha_estabelecimento().equals(senha)) {
                estabelecimento.setAutenticado(true);
                repositorioEstabelecimento.save(estabelecimento);
                return String.format("Login  de usuário %s realizado com sucesso!", estabelecimento.getNome_estabelecimento());
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
        for (Estabelecimento estabelecimento : repositorioEstabelecimento.findAll()) {
            if (estabelecimento.getEmail_estabelecimento().equals(email) && estabelecimento.getSenha_estabelecimento().equals(senha)) {
                estabelecimento.setAutenticado(false);
                repositorioEstabelecimento.save(estabelecimento);
                return String.format("Logoff  de usuário %s realizado com sucesso!", estabelecimento.getNome_estabelecimento());
            }
        }
        return String.format("Usuário de e-mail %s não encontrado!", email);
    }

    @GetMapping("/listar")
    public @ResponseBody
    List<Estabelecimento> listar() {
        return repositorioEstabelecimento.findAll();
    }
}
