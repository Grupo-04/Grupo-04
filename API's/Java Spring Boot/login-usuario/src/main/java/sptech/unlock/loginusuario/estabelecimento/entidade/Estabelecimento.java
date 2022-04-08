package sptech.unlock.loginusuario.estabelecimento.entidade;

import org.hibernate.validator.constraints.br.CNPJ;
import sptech.unlock.loginusuario.classeAbstrata.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
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

//    @JsonIgnore //Muito importante para evitar erro de lista infinita em método que busca todos usuários
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_endereco_estabelecimento", referencedColumnName = "id")
//    private Endereco endereco;

    public Estabelecimento() {
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
}
