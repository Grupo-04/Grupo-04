package sptech.mysql.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/endereco")
public class EnderecoController {

    @Autowired
    private RepositorioEndereco repositorioEndereco;

    @PostMapping(path = "/cadastrar")
    public @ResponseBody String cadastrarEndereco(@RequestBody Endereco endereco) {
        repositorioEndereco.save(endereco);
        return String.format("Endereco %s cadastrado com sucesso!", endereco);
    }

}
