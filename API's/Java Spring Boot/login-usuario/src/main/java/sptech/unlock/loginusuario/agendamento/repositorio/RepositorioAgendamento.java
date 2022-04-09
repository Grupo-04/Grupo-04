package sptech.unlock.loginusuario.agendamento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;

public interface RepositorioAgendamento extends JpaRepository<Agendamento, Integer> {
}
