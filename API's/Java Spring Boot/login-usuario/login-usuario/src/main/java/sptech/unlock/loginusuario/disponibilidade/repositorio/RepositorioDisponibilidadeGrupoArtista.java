package sptech.unlock.loginusuario.disponibilidade.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeGrupoArtista;
import sptech.unlock.loginusuario.grupoArtista.entidade.GrupoArtista;

import java.util.List;

public interface RepositorioDisponibilidadeGrupoArtista extends JpaRepository<DisponibilidadeGrupoArtista, Integer> {
    List<DisponibilidadeGrupoArtista> findAll();
}
