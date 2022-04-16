package sptech.unlock.loginusuario.disponibilidade.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.loginusuario.disponibilidade.controle.DisponibilidadeGrupoArtista;

import java.util.List;

public interface RepositorioDisponibilidadeGrupoArtista extends JpaRepository<DisponibilidadeGrupoArtista, Integer> {
    List<DisponibilidadeGrupoArtista> findAll();
}
