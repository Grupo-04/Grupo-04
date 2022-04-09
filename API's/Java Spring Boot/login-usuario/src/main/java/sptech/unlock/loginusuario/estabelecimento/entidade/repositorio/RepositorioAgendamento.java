package sptech.unlock.loginusuario.estabelecimento.entidade.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;

public interface RepositorioAgendamento extends JpaRepository<Agendamento, Integer> {
}
