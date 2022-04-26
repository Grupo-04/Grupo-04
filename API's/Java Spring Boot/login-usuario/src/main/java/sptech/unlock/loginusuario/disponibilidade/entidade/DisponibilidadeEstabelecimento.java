package sptech.unlock.loginusuario.disponibilidade.entidade;

import sptech.unlock.loginusuario.endereco.entidade.Endereco;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "disponibilidadeEstabelecimento")
public class DisponibilidadeEstabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer mes;
    private Integer dia_semana;
    private LocalDate hora_inicio; // somente horas
    private LocalDate hora_fim; // somente horas

//    TODO: Passar para session storage
    private Integer fk_estabelecimento;

    public DisponibilidadeEstabelecimento() {
    }

    public DisponibilidadeEstabelecimento(Integer id, Integer mes, Integer dia_semana, LocalDate hora_inicio, LocalDate hora_fim, Integer fk_estabelecimento) {
        this.id = id;
        this.mes = mes;
        this.dia_semana = dia_semana;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.fk_estabelecimento = fk_estabelecimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(Integer dia_semana) {
        this.dia_semana = dia_semana;
    }

    public LocalDate getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalDate hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalDate getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(LocalDate hora_fim) {
        this.hora_fim = hora_fim;
    }

    public Integer getFk_estabelecimento() {
        return fk_estabelecimento;
    }

    public void setFk_estabelecimento(Integer fk_estabelecimento) {
        this.fk_estabelecimento = fk_estabelecimento;
    }
}
