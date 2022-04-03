package sptech.unlock.pesquisanome.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento{

    @Id  // do pacote javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cnpj;
    private String horario;
    private String tipo;
    private Integer quantidade_artistas_suportados;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private Boolean autenticado;


    public Estabelecimento() {
    }

    public Estabelecimento(Integer id, String cnpj, String horario, String tipo, Integer quantidade_artistas_suportados, String nome, String telefone, String email, String senha, Boolean autenticado) {
        this.id = id;
        this.cnpj = cnpj;
        this.horario = horario;
        this.tipo = tipo;
        this.quantidade_artistas_suportados = quantidade_artistas_suportados;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
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
        return "Estabelecimento{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", horario='" + horario + '\'' +
                ", tipo='" + tipo + '\'' +
                ", quantidade_artistas_suportados=" + quantidade_artistas_suportados +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", autenticado=" + autenticado +
                '}';
    }
}
