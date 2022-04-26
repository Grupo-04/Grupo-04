package sptech.unlock.loginusuario.avaliacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.loginusuario.avaliacao.entidade.GrupoArtistaAvaliacaoAgendamento;

import java.util.List;

public interface RepositorioGrupoArtistaAvaliacaoAgendamento extends JpaRepository<GrupoArtistaAvaliacaoAgendamento, Integer> {
    List<GrupoArtistaAvaliacaoAgendamento> findAll();
}
