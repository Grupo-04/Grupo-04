package sptech.unlock.loginusuario.grupoArtista.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;

import java.util.List;

@Repository
public interface RepositorioGrupoArtista extends CrudRepository<GrupoArtista, Integer> {
    List<GrupoArtista> findAll();


}
