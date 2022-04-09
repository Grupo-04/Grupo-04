package sptech.unlock.loginusuario.agendamento.entidade;

import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo_agendamento;
    private String status_agendamento;
    private LocalDate dataEvento;
    private Double valorCobrado;

    @ManyToOne
    @JoinColumn(name = "fk_grupo_artista", referencedColumnName = "id")
    private GrupoArtista grupoArtistaAlocado;

    @ManyToOne
    @JoinColumn(name = "fk_estabelecimento", referencedColumnName = "id")
    private Estabelecimento estabelecimentoContratante;

    public Agendamento(Integer id, String codigo_agendamento, String status_agendamento, LocalDate dataEvento, Double valorCobrado, GrupoArtista grupoArtistaAlocado, Estabelecimento estabelecimentoContratante) {
        this.id = id;
        this.codigo_agendamento = codigo_agendamento;
        this.status_agendamento = status_agendamento;
        this.dataEvento = dataEvento;
        this.valorCobrado = valorCobrado;
        this.grupoArtistaAlocado = grupoArtistaAlocado;
        this.estabelecimentoContratante = estabelecimentoContratante;
    }

    public Agendamento() {
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

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public GrupoArtista getGrupoArtistaAlocado() {
        return grupoArtistaAlocado;
    }

    public void setGrupoArtistaAlocado(GrupoArtista grupoArtistaAlocado) {
        this.grupoArtistaAlocado = grupoArtistaAlocado;
    }

    public Estabelecimento getEstabelecimentoContratante() {
        return estabelecimentoContratante;
    }

    public void setEstabelecimentoContratante(Estabelecimento estabelecimentoContratante) {
        this.estabelecimentoContratante = estabelecimentoContratante;
    }
}
