package sptech.unlock.loginusuario.grupoArtista.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;

import java.util.List;

@Repository
public interface RepositorioGrupoArtista extends JpaRepository<GrupoArtista, Integer> {
    List<GrupoArtista> findAll();
}
