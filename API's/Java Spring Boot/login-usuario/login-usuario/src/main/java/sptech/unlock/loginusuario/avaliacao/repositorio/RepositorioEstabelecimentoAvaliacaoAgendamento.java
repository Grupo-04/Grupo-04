package sptech.unlock.loginusuario.avaliacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.loginusuario.avaliacao.entidade.EstabelecimentoAvaliacaoAgendamento;

import java.util.List;

public interface RepositorioEstabelecimentoAvaliacaoAgendamento extends JpaRepository<EstabelecimentoAvaliacaoAgendamento,Integer> {
    List<EstabelecimentoAvaliacaoAgendamento> findAll();
}
