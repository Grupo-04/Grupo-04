package sptech.unlock.loginusuario.endereco.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;
import sptech.unlock.loginusuario.endereco.repositorio.RepositorioEndereco;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {

    @Autowired
    private RepositorioEndereco enderecos;

    @PostMapping
    public ResponseEntity cadastrarEndereco(@RequestBody Endereco endereco){
        enderecos.save(endereco);
        return ResponseEntity.status(201).body(endereco);
    }

}
