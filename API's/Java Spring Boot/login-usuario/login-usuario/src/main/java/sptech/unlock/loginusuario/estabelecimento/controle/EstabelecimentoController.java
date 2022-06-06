package sptech.unlock.loginusuario.estabelecimento.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.email.service.EmailSenderService;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.interfaces.Autenticavel;
import sptech.unlock.loginusuario.interfaces.Registravel;
import sptech.unlock.loginusuario.observer.OctalObserver;
import sptech.unlock.loginusuario.observer.StringObserver;
import sptech.unlock.loginusuario.observer.Subject;
import java.util.Objects;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

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
            if (!Objects.isNull(estabelecimento)) {
                estabelecimento.setAutenticado(false);
                estabelecimento.setInteresse_match_cidade(false);
                estabelecimentos.save(estabelecimento);

                return ResponseEntity.status(201).body(estabelecimento);
            }
            return ResponseEntity.status(404).body("Operação Inválida! Informações inválidas...");
    }

    @PostMapping("/interesse-cidade/{id}")
    public ResponseEntity matchCidade(@PathVariable int id){
        if (Objects.isNull(estabelecimentos.findById(id))) {
            return ResponseEntity.status(204).build();
        }
        Estabelecimento estabelecimento = estabelecimentos.findById(id);
        estabelecimento.setInteresse_match_cidade(true);
        estabelecimentos.save(estabelecimento);

        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarEstabelecimento(@PathVariable Integer id ) {

        if (estabelecimentos.existsById(id)) {
            estabelecimentos.deleteById(id);
            return status(200).build();
        }
        return status(404).build();
    }

    @GetMapping("/listar/interessados-match-cidade")
    public ResponseEntity listarInteressadosEmMatchCidade() {
        List<Estabelecimento> lista = estabelecimentos.consultaInteressadosMatchCidade(true);

        if (lista.isEmpty()) {
            return status(204).build();
        }
        return status(200).body(lista);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/listar")
    @Override
    public ResponseEntity exibirTodos() {
        if (estabelecimentos.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(estabelecimentos.findAll());
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping
    @Override
    public ResponseEntity login(
            @RequestParam String email,
            @RequestParam String senha
    ) {

        Estabelecimento estab = estabelecimentos.findByEmailAndSenha(email, senha);
        if (Objects.isNull(estab)) {
            return ResponseEntity.status(404).build();
        }
        estab.setAutenticado(true);
        estabelecimentos.save(estab);

        return ResponseEntity.status(200).build();

    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping
    @Override
    public ResponseEntity logoff(
            @RequestParam String email,
            @RequestParam String senha
    ) {

        Estabelecimento estab = estabelecimentos.findByEmailAndSenha(email, senha);
        if (Objects.isNull(estab)) {
            return ResponseEntity.status(404).build();
        }
        estab.setAutenticado(false);
        estabelecimentos.save(estab);

        return ResponseEntity.status(200).build();

    }
}
