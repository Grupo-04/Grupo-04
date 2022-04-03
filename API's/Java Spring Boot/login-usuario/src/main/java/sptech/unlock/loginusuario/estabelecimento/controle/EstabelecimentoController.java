package sptech.unlock.loginusuario.estabelecimento.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.interfaces.Registravel;

import javax.validation.Valid;

//@Component
@RestController
@RequestMapping(path = "/estabelecimento")
public class EstabelecimentoController implements Registravel<ResponseEntity, Estabelecimento>{

    @Autowired
    private RepositorioEstabelecimento estabelecimentos;

    @PostMapping
    @Override
    public ResponseEntity cadastrar(@RequestBody Estabelecimento estabelecimento) {
        estabelecimentos.save(estabelecimento);
        return ResponseEntity.status(201).body(estabelecimento);
    }

//    @Override
//    @PostMapping
//    public ResponseEntity atualizar(@RequestBody Estabelecimento estabelecimento) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity excluir(String email, String senha) {
//        return null;
//    }

    @GetMapping
    @Override
    public ResponseEntity exibirTodos() {
        return ResponseEntity.status(200).body(estabelecimentos.findAll());
    }
}
