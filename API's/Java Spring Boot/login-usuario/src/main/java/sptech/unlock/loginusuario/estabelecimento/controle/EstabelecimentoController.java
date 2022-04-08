package sptech.unlock.loginusuario.estabelecimento.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.interfaces.Autenticavel;
import sptech.unlock.loginusuario.interfaces.Registravel;

import javax.validation.Valid;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(path = "/estabelecimento")
public class EstabelecimentoController implements Registravel<ResponseEntity, Estabelecimento>, Autenticavel {

    @Autowired
    private RepositorioEstabelecimento estabelecimentos;

    @PostMapping
    @Override
    public ResponseEntity cadastrar(@RequestBody Estabelecimento estabelecimento) {
        estabelecimentos.save(estabelecimento);
        return ResponseEntity.status(201).body(estabelecimento);
    }

    @GetMapping("/listar")
    @Override
    public ResponseEntity exibirTodos() {
        System.out.println(estabelecimentos.findAll().size()+1);
        return ResponseEntity.status(200).body(estabelecimentos.findAll());

    }

    @GetMapping
    @Override
    public ResponseEntity login(
            @RequestParam String email,
            @RequestParam String senha
    ) {

        for (Estabelecimento estab : estabelecimentos.findAll()){
            if (estab.getEmail().equals(email) && estab.getSenha().equals(senha)){
                estab.setAutenticado(true);
                return ResponseEntity.status(202).build();
            }
        }
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping
    @Override
    public ResponseEntity logoff(
            @RequestParam String email,
            @RequestParam String senha
    ) {

        for (Estabelecimento estab : estabelecimentos.findAll()){
            if (estab.getEmail().equals(email) && estab.getSenha().equals(senha)){
                estab.setAutenticado(false);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(200).build();
    }


    @GetMapping("/match")
    public ResponseEntity getEstabelecimento() {

        Random gerador = new Random();
        if (estabelecimentos.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        int range = estabelecimentos.findAll().size();
        int nroRandom = ThreadLocalRandom.current().nextInt(1, range);
        return ResponseEntity.status(200).body(estabelecimentos.findById(nroRandom));
    }
}
