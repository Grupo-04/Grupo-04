package sptech.unlock.artista.repositorio;

import org.springframework.data.repository.CrudRepository;
import sptech.unlock.artista.model.Artista;

import java.util.List;

public interface RepositorioArtista extends CrudRepository<Artista, Integer> {
    List<Artista> findAll();
}
