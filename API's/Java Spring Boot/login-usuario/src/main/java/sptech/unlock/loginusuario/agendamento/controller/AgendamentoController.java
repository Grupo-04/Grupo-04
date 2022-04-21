package sptech.unlock.loginusuario.agendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.agendamento.repositorio.RepositorioAgendamento;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping(path = "/agendamento")
public class AgendamentoController {

    @Autowired
    private RepositorioAgendamento agendamentos;

    @PostMapping("/{fk_estabelecimento}/{fk_grupo_artista}")
    public ResponseEntity adicionarAgendamento(
            @RequestBody Agendamento agendamento,
            @PathVariable Integer fk_estabelecimento,
            @PathVariable Integer fk_grupo_artista
    ){
        agendamento.setFk_estabelecimento(fk_estabelecimento);
        agendamento.setFk_grupo_artista(fk_estabelecimento);
        agendamentos.save(agendamento);
        return ResponseEntity.status(201).body(agendamento);
    }

//    @GetMapping
//    public ResponseEntity confirmarCodigo(@RequestParam String codigo){
//
//        return ResponseEntity.status(201).build();
//    }

//    @DeleteMapping
//    public ResponseEntity cancelar(@RequestParam String codigo){
//        return ResponseEntity.status(201).build();
//    }

    @GetMapping
    public ResponseEntity getAgendamentos(){
        if(agendamentos.findAll().isEmpty()){
            return ResponseEntity.status(204).body(agendamentos.findAll());
        }
        return ResponseEntity.status(200).body(agendamentos.findAll());
    }

    @GetMapping("/consultar-data/{data}")
    public ResponseEntity consultarPorData(
            @PathVariable() @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data
    ){

        for(Agendamento agend : agendamentos.findAll()){
            if(agend.getData_evento().equals(data)){
                return ResponseEntity.status(200).body(agend);
            }
        }
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/atualizar-data/{codigo_agendamento}/{data}")
    public ResponseEntity atualizarAgendamento(
            @PathVariable String codigo_agendamento,
            @PathVariable() @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data
    ){

        for(Agendamento agend : agendamentos.findAll()){
            if(agend.getCodigo_agendamento().equals(codigo_agendamento)){
                agend.setData_evento(data);
                agendamentos.save(agend);
                return ResponseEntity.status(200).body(agend);
            }
        }
        return ResponseEntity.status(400).build();
    }

    @PatchMapping("/atualizar-valor-cobrado/{codigo_agendamento}/{preco}")
    public ResponseEntity ataulizarValorCobrado(
            @PathVariable Double preco,
            @PathVariable String codigo_agendamento
    ){

        for(Agendamento agend : agendamentos.findAll()){
            if(agend.getCodigo_agendamento().equals(codigo_agendamento)){
                agend.setValor_cobrado(preco);
                agendamentos.save(agend);
                return ResponseEntity.status(200).body(agend);
            }
        }
        return ResponseEntity.status(400).build();
    }

    @DeleteMapping("/apagar-agendamento/{codigoAgendamento}")
    public ResponseEntity apagarAgendamento(
            @PathVariable String codigoAgendamento
    ){

        for(Agendamento agend : agendamentos.findAll()){
            if(agend.getCodigo_agendamento().equals(codigoAgendamento)){
                agendamentos.delete(agend);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(400).build();
    }

}
