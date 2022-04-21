package sptech.unlock.loginusuario.grupoArtista.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.email.service.EmailSenderService;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.repositorio.RepositorioGrupoArtista;
import sptech.unlock.loginusuario.interfaces.Autenticavel;
import sptech.unlock.loginusuario.interfaces.Registravel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(path = "/grupo-artista")
public class GrupoArtistaController implements Registravel<ResponseEntity, GrupoArtista>, Autenticavel {

    @Autowired
    private RepositorioGrupoArtista grupoArtistas;

    @Autowired
    private RepositorioEstabelecimento estabelecimentos;

    private GrupoArtista artista;


    @Autowired
    private EmailSenderService senderService;

    @PostMapping
    @Override
    public ResponseEntity cadastrar(@RequestBody GrupoArtista grupoArtista) {

            grupoArtista.setAutenticado(false);
            grupoArtistas.save(grupoArtista);

//            senderService.sendEmail(
//                    grupoArtista.getEmail(),
//                    "Cadastro realizado com sucesso!",
//                    "Acesse nosso site através do link www.example.com para completar o cadastro!"
//            );

            return ResponseEntity.status(201).body(grupoArtista);
    }

    @GetMapping("/listar")
    @Override
    public ResponseEntity exibirTodos() {
        return ResponseEntity.status(200).body(grupoArtistas.findAll());
    }

    @GetMapping
    @Override
    public ResponseEntity login(
            @RequestParam String email,
            @RequestParam String senha
    ) {

        for (GrupoArtista grup : grupoArtistas.findAll()){
            if (grup.getEmail().equals(email) && grup.getSenha().equals(senha)){
                grup.setAutenticado(true);
                grupoArtistas.save(grup);
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

        for (GrupoArtista grup : grupoArtistas.findAll()){
            if (grup.getEmail().equals(email) && grup.getSenha().equals(senha)){
                grup.setAutenticado(false);
                grupoArtistas.save(grup);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/match/{diaSelec}/{id}")
    public ResponseEntity getEstabelecimento(@PathVariable Integer diaSelec, @PathVariable Integer id) {

       for (int i = 0; i < grupoArtistas.findAll().size(); i++){
           if(grupoArtistas.findAll().get(i).getId() == id){
               artista = grupoArtistas.findAll().get(i);
           }
       }

        if (estabelecimentos.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        int rangeGeral = estabelecimentos.findAll().size();

        List<Estabelecimento> estabelecimentosMatchCidade = new ArrayList<>();

        for (Estabelecimento estab : estabelecimentos.findAll()){
            if (estab.getEndereco().getCidade().equalsIgnoreCase(artista.getEndereco().getCidade())){
                estabelecimentosMatchCidade.add(estab);
            }
        }

        List<Estabelecimento> estabelecimentosMatchCidadeNota = new ArrayList<>();

        for (int i = 0; i < estabelecimentosMatchCidade.size(); i++) {
            if (
                    estabelecimentosMatchCidade.get(i).getAvgNota() == artista.getAvgNota()
            ){
                estabelecimentosMatchCidadeNota.add(estabelecimentosMatchCidade.get(i));
            }

        }

        List<Estabelecimento> estabelecimentosMatchCidadeNotaDispo = new ArrayList<>();

        for (int i = 0; i < estabelecimentosMatchCidadeNota.size(); i++) {
            if (estabelecimentosMatchCidadeNota.get(i).getDisponibilidade(diaSelec)) {
                estabelecimentosMatchCidadeNotaDispo.add(estabelecimentosMatchCidadeNota.get(i));
            }
        }
        int rangeMatch = estabelecimentosMatchCidadeNotaDispo.size();
//        int nroRandom = ThreadLocalRandom.current().nextInt(0, rangeMatch+1);

        return ResponseEntity.status(200).body(estabelecimentosMatchCidadeNota);
//        return ResponseEntity.status(200).body(estabelecimentosMatchCidadeNotaDispo.get(nroRandom));
    }

}
