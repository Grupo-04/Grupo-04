package sptech.unlock.loginusuario.grupoArtista.entidade;

import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.classeAbstrata.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GrupoArtista extends Usuario {

//    @NotBlank
    private String nome_artistico;
    private String cpf;
    private String tipo;
    private Boolean grupo;
    private String estilo;

    @OneToMany
    private List<Agendamento> agendamentos = new ArrayList<>();

    public GrupoArtista() {
    }

    public String getNome_artistico() {
        return nome_artistico;
    }

    public void setNome_artistico(String nome_artistico) {
        this.nome_artistico = nome_artistico;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getGrupo() {
        return grupo;
    }

    public void setGrupo(Boolean grupo) {
        this.grupo = grupo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
