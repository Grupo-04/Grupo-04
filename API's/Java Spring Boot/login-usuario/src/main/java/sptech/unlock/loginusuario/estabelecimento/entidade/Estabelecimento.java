package sptech.unlock.loginusuario.estabelecimento.entidade;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sptech.unlock.loginusuario.classeAbstrata.Usuario;
//import sptech.unlock.loginusuario.endereco.entidade.Endereco;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "Estabelecimento")
public class Estabelecimento extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @NotBlank
    @Column(name = "cnpj", nullable = false, unique = true, length = 14)
    private String cnpj;
    @Column(name = "horario", nullable = false, unique = false, length = 200)
    private String horario;
    @Column(name = "tipo", nullable = false, unique = false, length = 45)
    private String tipo;
    @Column(name = "quantidade_artistas_suportados", nullable = false, unique = false)
    private Integer quantidade_artistas_suportados;



//    @JsonIgnore //Muito importante para evitar erro de lista infinita em método que busca todos usuários
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_endereco_estabelecimento", referencedColumnName = "id")
//    private Endereco endereco;


    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String telefone, String email, String senha, Boolean autenticado, Integer id, String cnpj, String horario, String tipo, Integer quantidade_artistas_suportados) {
        super(nome, telefone, email, senha, autenticado);
        this.id = id;
        this.cnpj = cnpj;
        this.horario = horario;
        this.tipo = tipo;
        this.quantidade_artistas_suportados = quantidade_artistas_suportados;
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

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", horario='" + horario + '\'' +
                ", tipo='" + tipo + '\'' +
                ", quantidade_artistas_suportados=" + quantidade_artistas_suportados +
                "} " + super.toString();
    }
}
