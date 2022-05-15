package sptech.unlock.loginusuario.doclayout;

import org.springframework.beans.factory.annotation.Autowired;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.agendamento.repositorio.RepositorioAgendamento;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeGrupoArtista;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Layout {
    
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

    public static void gravaArquivoTxt(List<Agendamento> lista, String nomeArquivo){
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
            corpo += String.format("%03d", a.getFk_estabelecimento());
            corpo += String.format("%03d", a.getFk_grupo_artista());
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
        LocalDate data_evento;
        Double valor_cobrado;
        Integer fk_grupo_artista, fk_estabelecimento;
        int contaRegDadoLido = 0;
        int qtdRegGravado = 0;

        List<Agendamento> listaLida = new ArrayList<>();

        try {
            entrada = new BufferedReader(new FileReader("Agendamento.txt"));
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
                    System.out.println("Data e hora de gravação do arquivo: " + registro.substring(13, 23));
                    System.out.println("Versão do documento de layout: " + registro.substring(23,25));
                } else if (tipoRegistro.equals("TR")) {
                    System.out.println("É um registro de trailer");
                    qtdRegGravado = Integer.parseInt(registro.substring(2,7));
                    if (contaRegDadoLido == qtdRegGravado) {
                        System.out.println("Quantidade de registros lidos compatível com a quantidade de registros gravados!");
                    } else {
                        System.out.println("Quantidade de registros lidos incompatível com a quantidade de registros gravados!");
                    }
                } else if (tipoRegistro.equals("CP") || tipoRegistro.equals("UC")) {
                    System.out.println("É um registro de corpo");
                    id = Integer.valueOf(registro.substring(2, 5));
                    codigo_agendamento = registro.substring(5, 11).trim();
                    status_agendamento = registro.substring(11, 21).trim();
                    data_evento = LocalDate.parse(registro.substring(21, 40).trim());
                    valor_cobrado = Double.valueOf(registro.substring(40, 46).replace(',', '.'));
                    fk_estabelecimento = Integer.valueOf(registro.substring(46,49));
                    fk_grupo_artista = Integer.valueOf(registro.substring(49,52));

                    contaRegDadoLido++;

                    Agendamento a = new Agendamento(id, codigo_agendamento, status_agendamento, data_evento, valor_cobrado,fk_estabelecimento, fk_grupo_artista);

                    //Para importar para o banco de dados pode-se fazer:
                    // repository.save(a);

                    // No nosso exemplo vamos adicionar o objeto a na listaLida;
                    listaLida.add(a);
                } else {
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
        //agendamentos.saveAll(listaLida);

        String retorno = "";

        for (Agendamento a : listaLida) {
            retorno += a+"\n";
        }
        return retorno;
    }
}
