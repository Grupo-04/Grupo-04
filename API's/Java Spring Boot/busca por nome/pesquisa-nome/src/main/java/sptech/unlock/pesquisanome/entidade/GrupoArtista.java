package sptech.unlock.pesquisanome.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrupoArtista {

    @Id  // do pacote javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome_artistico;
    private String cpf;
    private String tipo;
    private Boolean grupo;
    private String estilo;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private Boolean autenticado;

    public GrupoArtista() {
    }

    public GrupoArtista(Integer id, String nome_artistico, String cpf, String tipo, Boolean grupo, String estilo, String nome, String telefone, String email, String senha, Boolean autenticado) {
        this.id = id;
        this.nome_artistico = nome_artistico;
        this.cpf = cpf;
        this.tipo = tipo;
        this.grupo = grupo;
        this.estilo = estilo;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.autenticado = autenticado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    @Override
    public String toString() {
        return "GrupoArtista{" +
                "id=" + id +
                ", nome_artistico='" + nome_artistico + '\'' +
                ", cpf='" + cpf + '\'' +
                ", tipo='" + tipo + '\'' +
                ", grupo=" + grupo +
                ", estilo='" + estilo + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", autenticado=" + autenticado +
                '}';
    }
}
