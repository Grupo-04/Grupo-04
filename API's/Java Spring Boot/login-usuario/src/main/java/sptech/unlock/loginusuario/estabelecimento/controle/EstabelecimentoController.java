package sptech.unlock.loginusuario.estabelecimento.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.email.service.EmailSenderService;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.interfaces.Autenticavel;
import sptech.unlock.loginusuario.interfaces.Registravel;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/estabelecimento")
public class EstabelecimentoController implements Registravel<ResponseEntity, Estabelecimento>, Autenticavel {

    @Autowired
    private RepositorioEstabelecimento estabelecimentos;

    @Autowired
    private EmailSenderService senderService;

    @PostMapping
    @Override
    public ResponseEntity cadastrar(@RequestBody Estabelecimento estabelecimento) {


            estabelecimento.setAutenticado(false);
            estabelecimentos.save(estabelecimento);

//            senderService.sendEmail(
//                    estabelecimento.getEmail(),
//                    "Cadastro realizado com sucesso!",
//                    "Acesse nosso site através do link www.example.com para completar o cadastro!"
//            );

            return ResponseEntity.status(201).body(estabelecimento);
    }

    @GetMapping("/listar")
    @Override
    public ResponseEntity exibirTodos() {
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
                estabelecimentos.save(estab);
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
                estabelecimentos.save(estab);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(200).build();
    }
}
