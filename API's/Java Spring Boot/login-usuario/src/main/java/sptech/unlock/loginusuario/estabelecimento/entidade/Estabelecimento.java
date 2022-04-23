package sptech.unlock.loginusuario.estabelecimento.entidade;

import sptech.unlock.loginusuario.classeAbstrata.Usuario;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeEstabelecimento;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

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

    public Boolean getDisponibilidade(Integer i) {
        Boolean resu = true;

        if (i == 1) {
            resu = true;
        }
        if (i == 2) {
            resu = false;
        }
        if (i == 3) {
            resu = true;
        }
        if (i == 4) {
            resu = true;
        }
        if (i == 5) {
            resu = false;
        }
        if (i == 6) {
            resu = true;
        }
        if (i == 7) {
            resu = true;
        }
        if (i == 8) {
            resu = false;
        }
        if (i == 9) {
            resu = true;
        }
        if (i == 10) {
            resu = false;
        }
        if (i == 11) {
            resu = true;
        }
        if (i == 12) {
            resu = false;
        }
        if (i == 13) {
            resu = true;
        }
        if (i == 14) {
            resu = false;
        }
        if (i == 15) {
            resu = true;
        }
        if (i == 16) {
            resu = false;
        }
        if (i == 17) {
            resu = true;
        }
        if (i == 18) {
            resu = true;
        }
        if (i == 19) {
            resu = false;
        }
        if (i == 20) {
            resu = true;
        }
        if (i == 21) {
            resu = false;
        }
        if (i == 22) {
            resu = true;
        }
        if (i == 23) {
            resu = false;
        }
        if (i == 24) {
            resu = true;
        }
        if (i == 25) {
            resu = false;
        }
        if (i == 26) {
            resu = true;
        }
        if (i == 27) {
            resu = false;
        }
        if (i == 28) {
            resu = true;
        }
        if (i == 29) {
            resu = false;
        }
        if (i == 30) {
            resu = false;
        }
        return resu;
    }

    public Integer getAvgNota(){
        Integer nota = ThreadLocalRandom.current().nextInt(1, 10);
        return nota;
    }
}
