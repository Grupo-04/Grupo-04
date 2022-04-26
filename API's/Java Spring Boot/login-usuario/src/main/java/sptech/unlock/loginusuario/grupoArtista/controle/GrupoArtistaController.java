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
import sptech.unlock.loginusuario.observer.Observer;

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

    public void notifyAllObservers(List<Estabelecimento> estab, String nomeArtista){
        for (Estabelecimento e : estab) {
            update(e.getEmail(), nomeArtista);
        }
    }

    public void update(String email, String nomeArtista) {
        senderService.sendEmail(
                email,
                String.format("Novo Artista %s em sua cidade!", nomeArtista),
                "Você escolheu ser notificado cada vez que um novo artista em sua cidade é cadastrado," +
                        "para desabilitar esta opção acesse o site em www.example.com"
        );
    }

    @PostMapping
    @Override
    public ResponseEntity cadastrar(@RequestBody GrupoArtista grupoArtista) {

        List<Estabelecimento> estabelecimentosObservados = new ArrayList();

        for (Estabelecimento e: estabelecimentos.findAll()) {
            if (e.isInteresse_match_cidade()) {
                if (e.getEndereco().getCidade().equals(grupoArtista.getEndereco().getCidade())) {
                    estabelecimentosObservados.add(e);
                }
            }
        }

        if (estabelecimentosObservados.size() > 0) {
            notifyAllObservers(estabelecimentosObservados, grupoArtista.getNome_artistico());
        }

        grupoArtista.setAutenticado(false);
        grupoArtistas.save(grupoArtista);


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

        for (GrupoArtista grup : grupoArtistas.findAll()) {
            if (grup.getEmail().equals(email) && grup.getSenha().equals(senha)) {
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

        for (GrupoArtista grup : grupoArtistas.findAll()) {
            if (grup.getEmail().equals(email) && grup.getSenha().equals(senha)) {
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

        return ResponseEntity.status(200).body(estabelecimentosMatchCidadeNotaDispo);

    }

}
