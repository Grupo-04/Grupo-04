package sptech.unlock.loginusuario.agendamento.entidade;

import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agendamento")
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo_agendamento;
    private String status_agendamento;
    private LocalDate data_evento;
    private Double valor_cobrado;

    //    TODO: Passar para session storage
    private Integer fk_estabelecimento;
    private Integer fk_grupo_artista;

    public Agendamento() {
    }

    public Agendamento(Integer id, String codigo_agendamento, String status_agendamento, LocalDate data_evento, Double valor_cobrado, Integer fk_estabelecimento, Integer fk_grupo_artista) {
        this.id = id;
        this.codigo_agendamento = codigo_agendamento;
        this.status_agendamento = status_agendamento;
        this.data_evento = data_evento;
        this.valor_cobrado = valor_cobrado;
        this.fk_estabelecimento = fk_estabelecimento;
        this.fk_grupo_artista = fk_grupo_artista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo_agendamento() {
        return codigo_agendamento;
    }

    public void setCodigo_agendamento(String codigo_agendamento) {
        this.codigo_agendamento = codigo_agendamento;
    }

    public String getStatus_agendamento() {
        return status_agendamento;
    }

    public void setStatus_agendamento(String status_agendamento) {
        this.status_agendamento = status_agendamento;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public Double getValor_cobrado() {
        return valor_cobrado;
    }

    public void setValor_cobrado(Double valor_cobrado) {
        this.valor_cobrado = valor_cobrado;
    }

    public Integer getFk_estabelecimento() {
        return fk_estabelecimento;
    }

    public void setFk_estabelecimento(Integer fk_estabelecimento) {
        this.fk_estabelecimento = fk_estabelecimento;
    }

    public Integer getFk_grupo_artista() {
        return fk_grupo_artista;
    }

    public void setFk_grupo_artista(Integer fk_grupo_artista) {
        this.fk_grupo_artista = fk_grupo_artista;
    }
}
