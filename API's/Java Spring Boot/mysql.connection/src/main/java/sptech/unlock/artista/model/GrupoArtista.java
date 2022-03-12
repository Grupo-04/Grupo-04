package sptech.unlock.artista.model;

import sptech.unlock.estabelecimento.model.Estabelecimento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Grupo_Artista")
public class GrupoArtista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome_grupo;
    private String estilo_grupo;

    @OneToMany(
            mappedBy = "grupoArtista",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Artista> artista;

    public GrupoArtista(Integer id, String nome_grupo, String estilo_grupo, Set<Artista> artista) {
        this.id = id;
        this.nome_grupo = nome_grupo;
        this.estilo_grupo = estilo_grupo;
        this.artista = artista;
    }

    public GrupoArtista() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }

    public String getEstilo_grupo() {
        return estilo_grupo;
    }

    public void setEstilo_grupo(String estilo_grupo) {
        this.estilo_grupo = estilo_grupo;
    }

    public Set<Artista> getArtista() {
        return artista;
    }

    public void setArtista(Set<Artista> artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "GrupoArtista{" +
                "id=" + id +
                ", nome_grupo='" + nome_grupo + '\'' +
                ", estilo_grupo='" + estilo_grupo + '\'' +
                ", artista=" + artista +
                '}';
    }
}
