package sptech.unlock.loginusuario.classeAbstrata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Table;

@Component
@Table(name = "Estabelecimento")
public abstract class Usuario {

    @Column(name = "nome", nullable = false, unique = true, length = 45)
    private String nome;
    @Column(name = "telefone", nullable = false, unique = true, length = 15)
    private String telefone;
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "senha", nullable = false, unique = true, length = 45)
    private String senha;
    @Column(name = "autenticado", nullable = false, unique = true)
    private Boolean autenticado;

    public Usuario(String nome, String telefone, String email, String senha, Boolean autenticado) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.autenticado = autenticado;
    }

    public Usuario() {
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

    public Boolean getAutenticacao() {
        return autenticado;
    }

    public void setAutenticacao(Boolean autenticacao) {
        this.autenticado = autenticacao;
    }
}
