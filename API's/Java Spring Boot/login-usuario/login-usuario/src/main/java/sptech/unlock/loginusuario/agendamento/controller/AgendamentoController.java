package sptech.unlock.loginusuario.agendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.agendamento.repositorio.RepositorioAgendamento;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.listaobj.ListaObj;

import javax.swing.filechooser.FileSystemView;
import javax.validation.Valid;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.FormatterClosedException;

@RestController
@RequestMapping(path = "/agendamento")
public class AgendamentoController {

    public void gravaArquivoCsv(ListaObj<Agendamento> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            String pathDocuments = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            arq = new FileWriter(pathDocuments + "\\" + nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Agendamento agend = lista.getElemento(i);
                saida.format("%d;%s;%s;%s;%.2f;%d;%d\n",agend.getId(), agend.getCodigo_agendamento(),
                        agend.getStatus_agendamento(), agend.getData_evento(), agend.getValor_cobrado(),
                        agend.getFk_estabelecimento(), agend.getFk_grupo_artista());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

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
    public ResponseEntity cancelarAgendamento(
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

    @PostMapping("/baixar-csv/{id}")
    public ResponseEntity baixarCsv(@PathVariable Integer id){

        ListaObj<Agendamento> agendamentoListaObj = new ListaObj<>(agendamentos.findAll().size());

        for (Agendamento agend : agendamentos.findAll()){
            if (agend.getFk_estabelecimento() == id || agend.getFk_grupo_artista() == id){
                agendamentoListaObj.adiciona(agend);
            }
        }

        if (agendamentoListaObj.getNumeroElemento() == 0){
            return ResponseEntity.status(400).build();
        }

        gravaArquivoCsv(agendamentoListaObj, "Agendamentos");
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/baixar-csv-ordenado/{id}")
    public ResponseEntity baixarCsvOrdenado(@PathVariable Integer id){

        ListaObj<Agendamento> agendamentoListaObj = new ListaObj<>(agendamentos.findAll().size());

        for (Agendamento agend : agendamentos.findAll()){
            if (agend.getFk_estabelecimento() == id || agend.getFk_grupo_artista() == id){
                agendamentoListaObj.adiciona(agend);
            }
        }

        // Ordenar por valor cobrado
        int indMenor = 0;
        double aux = 0.0;

        for (int i = 0; i < agendamentoListaObj.getTamanho() - 1; i++) {
            indMenor = i;
            for (int j = i + 1; j < agendamentoListaObj.getTamanho(); j++) {

                if (agendamentoListaObj.getElemento(j).getValor_cobrado() < agendamentoListaObj.getElemento(indMenor).getValor_cobrado()) {
                    indMenor = j;
                }
            }

            aux = agendamentoListaObj.getElemento(i).getValor_cobrado();
            agendamentoListaObj.getElemento(i).setValor_cobrado(agendamentoListaObj.getElemento(indMenor).getValor_cobrado());
            agendamentoListaObj.getElemento(indMenor).setValor_cobrado(aux);
        }

        if (agendamentoListaObj.getNumeroElemento() == 0){
            return ResponseEntity.status(400).build();
        }

        gravaArquivoCsv(agendamentoListaObj, "AgendamentosPorPreco");
        return ResponseEntity.status(201).build();
    }

//[{
//        "codigo_agendamento": "AABB12",
//                "status_agendamento": "Aprovado",
//                "data_evento": "2022-04-30",
//                "valor_cobrado": 90.0
//    },{
//        "codigo_agendamento": "CCDD34",
//                "status_agendamento": "Em aprovacao",
//                "data_evento": "2022-05-07",
//                "valor_cobrado": 150.0
//    },{
//        "codigo_agendamento": "EEFF56",
//                "status_agendamento": "Em aprovacao",
//                "data_evento": "2022-05-14",
//                "valor_cobrado": 190.0
//    }]

//    @GetMapping
//    public ResponseEntity confirmarCodigo(@RequestParam String codigo){
//
//        return ResponseEntity.status(201).build();
//    }

//    @DeleteMapping
//    public ResponseEntity cancelar(@RequestParam String codigo){
//        return ResponseEntity.status(201).build();
//    }

}
