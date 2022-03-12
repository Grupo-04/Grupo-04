package sptech.unlock.artista.repositorio;

import org.springframework.data.repository.CrudRepository;
import sptech.unlock.artista.model.GrupoArtista;

import java.util.List;

public interface RepositorioGrupoArtista extends CrudRepository<GrupoArtista, Integer> {
    List <GrupoArtista> findAll();
}
