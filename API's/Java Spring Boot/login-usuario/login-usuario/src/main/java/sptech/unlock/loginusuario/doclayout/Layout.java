package sptech.unlock.loginusuario.doclayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.agendamento.repositorio.RepositorioAgendamento;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeGrupoArtista;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.repositorio.RepositorioGrupoArtista;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Layout {

    @Autowired
    RepositorioAgendamento agendamentoEntrada;

    @Autowired
    RepositorioGrupoArtista grupoArtistaEntrada;

    public Layout() {
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
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
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
                    agendamentoEntrada.save(a);

                    // No nosso exemplo vamos adicionar o objeto a na listaLida;
                    //listaLida.add(a);
                    System.out.println(listaLida);

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
                    grupoArtistaEntrada.save(grupoArtista);

                    // No nosso exemplo vamos adicionar o objeto a na listaLida;
                    //listaLidaArtista.add(grupoArtista);
                    System.out.println(listaLidaArtista);

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
}
