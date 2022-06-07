package sptech.unlock.loginusuario.recuperarSenha;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Codigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codigo;

    private Integer idArtista;

    public Codigo(Integer id, String codigo, Integer idArtista) {
        this.id = id;
        this.codigo = codigo;
        this.idArtista = idArtista;
    }

    public Codigo(String codigo, Integer idArtista) {
        this.codigo = codigo;
        this.idArtista = idArtista;
    }

    public Codigo() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
