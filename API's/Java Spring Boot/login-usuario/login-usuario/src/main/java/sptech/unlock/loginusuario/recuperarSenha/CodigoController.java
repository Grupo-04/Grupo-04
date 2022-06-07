package sptech.unlock.loginusuario.recuperarSenha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/codigo-recuperacao")
public class CodigoController {

    @Autowired
    private RepositorioCodigo codigos;

    @GetMapping
    public ResponseEntity getCodigo(@RequestParam Integer id) {
        Codigo codigo = codigos.findById(id).get();

        return ResponseEntity.status(200).body(codigo);
    }

    @GetMapping("/listar")
    public ResponseEntity listarCodigos(){
        List<Codigo> lista = codigos.findAll();

        if (lista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity postCodigo(@RequestBody Codigo codigo) {
        codigos.save(codigo);
        return ResponseEntity.status(201).body(codigo);
    }
}
