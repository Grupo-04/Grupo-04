package sptech.unlock.loginusuario.estabelecimento.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.beans.factory.annotation.Autowired;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.classeAbstrata.Usuario;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "estabelecimento")
public class Estabelecimento extends Usuario{

//    @CNPJ
//    @NotBlank
    private String cnpj;

//    @NotBlank
    private LocalDate horario;

//    @NotBlank
    private String tipo;

//    @NotBlank
//    @Positive
    private Integer quantidade_artistas_suportados;


//    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_endereco_estabelecimento", referencedColumnName = "id")
    private Endereco endereco;

    public Estabelecimento() {
    }

    public Estabelecimento(Integer id, String nome, String telefone, String email, String senha, String cnpj, LocalDate horario, String tipo, Integer quantidade_artistas_suportados, Endereco endereco) {
        super(id, nome, telefone, email, senha);
        this.cnpj = cnpj;
        this.horario = horario;
        this.tipo = tipo;
        this.quantidade_artistas_suportados = quantidade_artistas_suportados;
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade_artistas_suportados() {
        return quantidade_artistas_suportados;
    }

    public void setQuantidade_artistas_suportados(Integer quantidade_artistas_suportados) {
        this.quantidade_artistas_suportados = quantidade_artistas_suportados;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

//    public List<Agendamento> getAgendamentos() {
//        return agendamentos;
//    }
//
//    public void setAgendamentos(List<Agendamento> agendamentos) {
//        this.agendamentos = agendamentos;
//    }
}
