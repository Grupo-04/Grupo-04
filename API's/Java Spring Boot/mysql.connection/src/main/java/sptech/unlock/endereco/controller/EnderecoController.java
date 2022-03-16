package sptech.unlock.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.endereco.repositorio.RepositorioEndereco;
import sptech.unlock.endereco.model.Endereco;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private RepositorioEndereco repositorioEndereco;

    @PostMapping //(path = "/cadastrar")
    public @ResponseBody String cadastrarEndereco(@RequestBody Endereco endereco) {
        repositorioEndereco.save(endereco);
        return String.format("Endereco %s cadastrado com sucesso!", endereco);
    }

}
