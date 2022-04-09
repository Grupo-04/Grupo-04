package sptech.unlock.loginusuario.agendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.agendamento.repositorio.RepositorioAgendamento;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/agendamento")
public class AgendamentoController {

    @Autowired
    private RepositorioAgendamento agendamentos;

    @PostMapping("/{id}")
    public ResponseEntity adicionarAgendamento(@RequestBody Agendamento agendamento, @PathVariable Integer id){
        agendamento.setFk_estabelecimento(id);
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

    @GetMapping("/consultar-data/{data}")
    public ResponseEntity consultarPorData(@PathVariable LocalDate data){

        for(Agendamento agend : agendamentos.findAll()){
            if(agend.getData_evento().equals(data)){
                return ResponseEntity.status(200).body(agend);
            }
        }
        return ResponseEntity.status(400).build();
    }

}
