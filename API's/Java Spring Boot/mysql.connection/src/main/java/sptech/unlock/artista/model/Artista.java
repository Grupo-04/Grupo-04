package sptech.unlock.artista.model;

import org.springframework.lang.Nullable;
import sptech.unlock.endereco.model.Endereco;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Artista")
public class Artista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome_artista;
    private String nome_artistico;
    private String telefone_artista;
    private String cpf_artista;
    private String tipo_artista;
    private String email_artista;
    private String senha_artista;
    private boolean grupo;
    private boolean autenticado;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_grupo", nullable = true)
    private GrupoArtista grupoArtista;


    public Artista(Integer id, String nome_artista, String nome_artistico, String telefone_artista, String cpf_artista, String tipo_artista, String email_artista, String senha_artista, boolean grupo, GrupoArtista grupoArtista) {
        this.id = id;
        this.nome_artista = nome_artista;
        this.nome_artistico = nome_artistico;
        this.telefone_artista = telefone_artista;
        this.cpf_artista = cpf_artista;
        this.tipo_artista = tipo_artista;
        this.email_artista = email_artista;
        this.senha_artista = senha_artista;
        this.grupo = grupo;
        this.autenticado = false;
        this.grupoArtista = grupoArtista;
    }

    public Artista() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_artista() {
        return nome_artista;
    }

    public void setNome_artista(String nome_artista) {
        this.nome_artista = nome_artista;
    }

    public String getNome_artistico() {
        return nome_artistico;
    }

    public void setNome_artistico(String nome_artistico) {
        this.nome_artistico = nome_artistico;
    }

    public String getTelefone_artista() {
        return telefone_artista;
    }

    public void setTelefone_artista(String telefone_artista) {
        this.telefone_artista = telefone_artista;
    }

    public String getCpf_artista() {
        return cpf_artista;
    }

    public void setCpf_artista(String cpf_artista) {
        this.cpf_artista = cpf_artista;
    }

    public String getTipo_artista() {
        return tipo_artista;
    }

    public void setTipo_artista(String tipo_artista) {
        this.tipo_artista = tipo_artista;
    }

    public String getEmail_artista() {
        return email_artista;
    }

    public void setEmail_artista(String email_artista) {
        this.email_artista = email_artista;
    }

    public String getSenha_artista() {
        return senha_artista;
    }

    public void setSenha_artista(String senha_artista) {
        this.senha_artista = senha_artista;
    }

    public boolean isGrupo() {
        return grupo;
    }

    public void setGrupo(boolean grupo) {
        this.grupo = grupo;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public GrupoArtista getGrupoArtista() {
        return grupoArtista;
    }

    public void setGrupoArtista(GrupoArtista grupoArtista) {
        this.grupoArtista = grupoArtista;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nome_artista='" + nome_artista + '\'' +
                ", nome_artistico='" + nome_artistico + '\'' +
                ", telefone_artista='" + telefone_artista + '\'' +
                ", cpf_artista='" + cpf_artista + '\'' +
                ", tipo_artista='" + tipo_artista + '\'' +
                ", email_artista='" + email_artista + '\'' +
                ", senha_artista='" + senha_artista + '\'' +
                ", grupo=" + grupo +
                ", autenticado=" + autenticado +
                ", grupoArtista=" + grupoArtista +
                '}';
    }
}
