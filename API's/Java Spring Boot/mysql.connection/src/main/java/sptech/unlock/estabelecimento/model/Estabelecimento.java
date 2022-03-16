package sptech.unlock.estabelecimento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sptech.unlock.endereco.model.Endereco;

import javax.persistence.*;

@Entity
@Table(name = "Estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String cnpj;
    private String nome_estabelecimento;
    private String telefone_estabelecimento;
    private String email_estabelecimento;
    private String senha_estabelecimento;
    private String horario_atendimento;
    private String tipo_estabelecimento;
    private Integer quantidade_artistas_suportados;
    private boolean autenticado;

    @JsonIgnore //Muito importante para evitar erro de lista infinita em método que busca todos usuários
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_endereco_estabelecimento", referencedColumnName = "id")
    private Endereco endereco;

    public Estabelecimento(Integer id, String cnpj, String nome_estabelecimento, String telefone_estabelecimento, String email_estabelecimento, String senha_estabelecimento, String horario_atendimento, String tipo_estabelecimento, Integer quantidade_artistas_suportados, Endereco endereco) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome_estabelecimento = nome_estabelecimento;
        this.telefone_estabelecimento = telefone_estabelecimento;
        this.email_estabelecimento = email_estabelecimento;
        this.senha_estabelecimento = senha_estabelecimento;
        this.horario_atendimento = horario_atendimento;
        this.tipo_estabelecimento = tipo_estabelecimento;
        this.quantidade_artistas_suportados = quantidade_artistas_suportados;
        this.autenticado = false;
        this.endereco = endereco;
    }

    public Estabelecimento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_estabelecimento() {
        return nome_estabelecimento;
    }

    public void setNome_estabelecimento(String nome_estabelecimento) {
        this.nome_estabelecimento = nome_estabelecimento;
    }

    public String getTelefone_estabelecimento() {
        return telefone_estabelecimento;
    }

    public void setTelefone_estabelecimento(String telefone_estabelecimento) {
        this.telefone_estabelecimento = telefone_estabelecimento;
    }

    public String getEmail_estabelecimento() {
        return email_estabelecimento;
    }

    public void setEmail_estabelecimento(String email_estabelecimento) {
        this.email_estabelecimento = email_estabelecimento;
    }

    public String getSenha_estabelecimento() {
        return senha_estabelecimento;
    }

    public void setSenha_estabelecimento(String senha_estabelecimento) {
        this.senha_estabelecimento = senha_estabelecimento;
    }

    public String getHorario_atendimento() {
        return horario_atendimento;
    }

    public void setHorario_atendimento(String horario_atendimento) {
        this.horario_atendimento = horario_atendimento;
    }

    public String getTipo_estabelecimento() {
        return tipo_estabelecimento;
    }

    public void setTipo_estabelecimento(String tipo_estabelecimento) {
        this.tipo_estabelecimento = tipo_estabelecimento;
    }

    public Integer getQuantidade_artistas_suportados() {
        return quantidade_artistas_suportados;
    }

    public void setQuantidade_artistas_suportados(Integer quantidade_artistas_suportados) {
        this.quantidade_artistas_suportados = quantidade_artistas_suportados;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", nome_estabelecimento='" + nome_estabelecimento + '\'' +
                ", telefone_estabelecimento='" + telefone_estabelecimento + '\'' +
                ", email_estabelecimento='" + email_estabelecimento + '\'' +
                ", senha_estabelecimento='" + senha_estabelecimento + '\'' +
                ", horario_atendimento='" + horario_atendimento + '\'' +
                ", tipo_estabelecimento='" + tipo_estabelecimento + '\'' +
                ", quantidade_artistas_suportados=" + quantidade_artistas_suportados +
                ", autenticado=" + autenticado +
                ", endereco=" + endereco +
                '}';
    }
}
