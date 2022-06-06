package sptech.unlock.loginusuario.grupoArtista.entidade;

import sptech.unlock.loginusuario.classeAbstrata.Usuario;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "grupoArtista")
public class GrupoArtista extends Usuario {

//    @NotBlank
    private String nome_artistico;
    private String cpf;
    private String tipo;
    private Boolean grupo;
    private String estilo;
    private Integer qtdIntegrantes;

//    @OneToMany
//    private Agendamento agendamentos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "GrupoArtistaHasEndereco",
            joinColumns =
                    { @JoinColumn(name = "fk_grupo_artista", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "fk_endereco", referencedColumnName = "id") })
    private Endereco endereco;

    public GrupoArtista() {
    }

    public GrupoArtista(Integer id, String nome, String telefone, String email, String senha, String nome_artistico, String cpf, String tipo, Boolean grupo, String estilo, Integer qtdIntegrantes, Endereco endereco) {
        super(id, nome, telefone, email, senha);
        this.nome_artistico = nome_artistico;
        this.cpf = cpf;
        this.tipo = tipo;
        this.grupo = grupo; 
        this.estilo = estilo;
        this.qtdIntegrantes = qtdIntegrantes;
        this.endereco = endereco;
    }

    public GrupoArtista(Integer id, String nome, String telefone, String email, String senha, String nome_artistico, String cpf, String tipo, Boolean grupo, String estilo, Integer qtdIntegrantes) {
        super(id, nome, telefone, email, senha);
        this.nome_artistico = nome_artistico;
        this.cpf = cpf;
        this.tipo = tipo;
        this.grupo = grupo;
        this.estilo = estilo;
        this.qtdIntegrantes = qtdIntegrantes;
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

    public Integer getQtdIntegrantes() {
        return qtdIntegrantes;
    }

    public void setQtdIntegrantes(Integer qtdIntegrantes) {
        this.qtdIntegrantes = qtdIntegrantes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getAvgNota(){
        Integer nota = ThreadLocalRandom.current().nextInt(1, 10);
        return nota;
    }
}
