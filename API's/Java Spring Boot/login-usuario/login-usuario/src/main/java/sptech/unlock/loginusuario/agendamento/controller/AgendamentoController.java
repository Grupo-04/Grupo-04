package sptech.unlock.loginusuario.agendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.unlock.loginusuario.agendamento.repositorio.RepositorioAgendamento;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.doclayout.Layout;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.estabelecimento.repositorio.RepositorioEstabelecimento;
import sptech.unlock.loginusuario.filaobj.FilaObj;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.repositorio.RepositorioGrupoArtista;
import sptech.unlock.loginusuario.listaobj.ListaObj;
import sptech.unlock.loginusuario.pilhaobj.PilhaObj;

import javax.swing.filechooser.FileSystemView;
import javax.validation.Valid;
import java.io.*;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

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

    @Autowired
    private RepositorioEstabelecimento estabelecimentos;

    @Autowired
    private RepositorioGrupoArtista grupoArtistaEntrada;

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

    public FilaObj<Agendamento> enfileirarAgendamento(List<Agendamento> listaAgendamento) {
        FilaObj<Agendamento> filaAgendamento = new FilaObj<>(listaAgendamento.size());

        for (int i = 0; i < listaAgendamento.size(); i++) {
            filaAgendamento.insert(listaAgendamento.get(i));
        }

        return filaAgendamento;
    }

    @GetMapping("/enfileirar")
    public  ResponseEntity getFilaAgendamento(){
        if(enfileirarAgendamento(agendamentos.findAll()).isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(enfileirarAgendamento(agendamentos.findAll()));
    }

    @GetMapping("/primeiro-agendamento")
    public ResponseEntity getPrimeiroEmpilhado(){
        if(enfileirarAgendamento(agendamentos.findAll()).isEmpty()){
            return ResponseEntity.status(404).build();
        } else {
//            enfileirarAgendamento(agendamentos.findAll()).poll();
//            int ultimo = agendamentos.findAll().size()-1;
//            agendamentos.delete(agendamentos.findAll().get(ultimo));
            return ResponseEntity.status(200).body(enfileirarAgendamento(agendamentos.findAll()).peek());
        }
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
            @PathVariable() @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime data
    ){

        for(Agendamento agend : agendamentos.findAll()){
            if(agend.getData_evento().equals(data)) {
                return ResponseEntity.status(200).body(agend);
            }
        }
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/atualizar-data/{codigo_agendamento}/{data}")
    public ResponseEntity atualizarAgendamento(
            @PathVariable String codigo_agendamento,
            @PathVariable() @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime data
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
    public ResponseEntity atualizarValorCobrado(
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

    @GetMapping("/exportar-dados-agendamento")
    public ResponseEntity getTxtDadosAgendamento(){
//        Layout exportar = new Layout();
        if (agendamentos.findAll().isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
//            exportar.gravaArquivoTxt(agendamentos.findAll(), estabelecimentos.findAll(),"Agendamento.txt");
            gravaArquivoTxt(agendamentos.findAll(), estabelecimentos.findAll(),"Agendamento.txt");
            return ResponseEntity.status(200).build();
        }
    }

    @PostMapping("/importar-dados-agendamento")
    public ResponseEntity postTxtDadosAgendamento(){
//        Layout importar = new Layout();
//        return ResponseEntity.status(201).body(importar.leArquivoTxt("AgendamentoEntrada.txt"));
        return ResponseEntity.status(201).body(leArquivoTxt("AgendamentoEntrada.txt"));
    }

    public static void gravaRegistro(String registro, String nomeArquivo){
        BufferedWriter saida = null;

        try{
            saida = new BufferedWriter(new FileWriter(nomeArquivo,true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        try{
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: " + erro);
        }
    }

    public static void gravaArquivoTxt(List<Agendamento> lista, List<Estabelecimento> listaEstabelecimento, String nomeArquivo){
        int contaRegistroCorpo = 0;

        //Monta o registro de Header
        String header = "HDAGENDAMENTO";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        header += "01";
        //Gravar o registro de header
        gravaRegistro(header, nomeArquivo);

        //Monta e grava os registros de Corpo de Agendamento
        for (Agendamento a : lista) {
            String corpo = "CP";
            corpo += String.format("%03d", a.getId());
            corpo += String.format("%6.6s", a.getCodigo_agendamento());
            corpo += String.format("%-10.10s", a.getStatus_agendamento());
            corpo += String.format("%-19.19s", a.getData_evento());
            corpo += String.format("%06.2f", a.getValor_cobrado());
            gravaRegistro(corpo, nomeArquivo);
            contaRegistroCorpo++;
        }

        for (Estabelecimento e : listaEstabelecimento) {
            String corpo = "EC";
            corpo += String.format("%03d", e.getId());
            corpo += String.format("%-45.45s", e.getNome());
            corpo += String.format("%-45.45s", e.getEmail());
            gravaRegistro(corpo, nomeArquivo);
            contaRegistroCorpo++;
        }

        //Monta e grava o registro de Trailer
        String trailer = "TR";
        trailer += String.format("%05d", contaRegistroCorpo);
        gravaRegistro(trailer, nomeArquivo);
    }

    public String leArquivoTxt(String nomeArquivo){
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        Integer id;
        String codigo_agendamento;
        String status_agendamento;
        LocalDateTime data_evento;

        //GrupoArtista
        Integer idArtista;
        String nome;
        String nomeArtistico;
        String cpf;
        String telefone;
        String email;
        String senha;
        String tipo;
        Boolean grupo;
        String estilo;

        Double valor_cobrado;
        int contaRegDadoLido = 0;
        int qtdRegGravado = 0;

        List<Agendamento> listaLida = new ArrayList<>();
        List<GrupoArtista> listaLidaArtista = new ArrayList<>();

        try {
            entrada = new BufferedReader(new FileReader("AgendamentoEntrada.txt"));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        try{
            // le o primeiro registro do arquivo
            registro = entrada.readLine();
            while (registro != null) { // enquanto não é fim do arquivo
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("HD")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2,13));
                    System.out.println("Data e hora de gravação do arquivo: " + registro.substring(13, 32));
                    System.out.println("Versão do documento de layout: " + registro.substring(32,34));
                } else if (tipoRegistro.equals("TR")) {
                    System.out.println("É um registro de trailer");
                    qtdRegGravado = Integer.parseInt(registro.substring(2,7));
                    if (contaRegDadoLido == qtdRegGravado) {
                        System.out.println("Quantidade de registros lidos compatível com a quantidade de registros gravados!");
                    } else {
                        System.out.println("Quantidade de registros lidos incompatível com a quantidade de registros gravados!");
                    }
                } else if (tipoRegistro.equals("CP")) {
                    System.out.println("É um registro de corpo de Agendamento");
                    id = Integer.valueOf(registro.substring(2, 5));
                    codigo_agendamento = registro.substring(5, 11).trim();
                    status_agendamento = registro.substring(11, 21).trim();
                    data_evento = LocalDateTime.parse(registro.substring(21, 40).trim());
                    valor_cobrado = Double.valueOf(registro.substring(40, 46).replace(',', '.'));

                    contaRegDadoLido++;

                    Agendamento a = new Agendamento(id, codigo_agendamento, status_agendamento, data_evento, valor_cobrado);

                    //Para importar para o banco de dados pode-se fazer:
                    //agendamentos.save(a);

                    // No nosso exemplo vamos adicionar o objeto a na listaLida;
                    listaLida.add(a);
                    //System.out.println(listaLida);
                    agendamentos.saveAll(listaLida);

                } else if (tipoRegistro.equals("AC")){
                    System.out.println("É um registro de corpo de Grupo Artista");
                    idArtista = Integer.valueOf(registro.substring(2, 5));
                    nome = registro.substring(5, 50).trim();
                    nomeArtistico = registro.substring(50, 95).trim();
                    cpf = registro.substring(95, 109).trim();
                    telefone = registro.substring(109,124).trim();
                    email = registro.substring(124,169).trim();
                    senha = registro.substring(169, 214).trim();
                    tipo = registro.substring(214, 259).trim();
                    grupo = Boolean.valueOf(registro.substring(259, 260).trim());
                    estilo = registro.substring(260, 305);

                    contaRegDadoLido++;

                    GrupoArtista grupoArtista = new GrupoArtista(idArtista, nome, telefone, email, senha, nomeArtistico, cpf, tipo, grupo, estilo);

                    //Para importar para o banco de dados pode-se fazer:
                    //grupoArtistaEntrada.save(grupoArtista);

                    // No nosso exemplo vamos adicionar o objeto a na listaLida;
                    listaLidaArtista.add(grupoArtista);
                    //System.out.println(listaLidaArtista);

                    grupoArtistaEntrada.saveAll(listaLidaArtista);

                }
                else {
                    System.out.println("Tipo de registro inválido");
                }
                // le o proximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro na leitura do arquivo");
        }

        //Aqui opcionalmente, pode-se importar a listaLida para o banco de dados;
        //agendamentoEntrada.saveAll(listaLida);
        //grupoArtistaEntrada.saveAll(listaLidaArtista);

        String retorno = "";

        for (Agendamento a : listaLida) {
            retorno += a+"\n";
        }
        return retorno;
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
