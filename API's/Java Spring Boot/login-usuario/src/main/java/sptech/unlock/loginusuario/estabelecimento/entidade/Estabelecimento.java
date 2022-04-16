package sptech.unlock.loginusuario.estabelecimento.entidade;

import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;
import sptech.unlock.loginusuario.classeAbstrata.Usuario;
import sptech.unlock.loginusuario.disponibilidade.controle.DisponibilidadeEstabelecimento;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public Estabelecimento(Integer id, String nome, String telefone, String email, String senha, String cnpj, LocalDate horario, String tipo, Integer quantidade_artistas_suportados, Endereco endereco, DisponibilidadeEstabelecimento disponibilidadeEstabelecimento) {
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
}
