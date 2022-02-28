package sptech.mysql.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

    @Autowired
    private RepositorioEstabelecimento repositorioEstabelecimento;

    @PostMapping("/cadastrar")
    public @ResponseBody String cadastrarEstabelecimento(
            @RequestBody Estabelecimento estabelecimento
    ) {
        repositorioEstabelecimento.save(estabelecimento);
        return String.format("%s Cadastrado com sucesso!", estabelecimento);
    }
}
