package sptech.unlock.pesquisanome.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.pesquisanome.entidade.Estabelecimento;
import sptech.unlock.pesquisanome.entidade.GrupoArtista;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoControler {

    private List<Estabelecimento> estabelecimentos = new ArrayList<>();

    @PostMapping
    public ResponseEntity cadastrarEstabelecimento(@RequestBody Estabelecimento estabelecimento){
        estabelecimentos.add(estabelecimento);
        return ResponseEntity.status(201).build();
    }
}
