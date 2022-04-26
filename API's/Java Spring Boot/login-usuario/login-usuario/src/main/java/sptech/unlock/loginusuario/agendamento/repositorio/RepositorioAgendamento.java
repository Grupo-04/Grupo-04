package sptech.unlock.loginusuario.agendamento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;

import java.util.List;

public interface RepositorioAgendamento extends JpaRepository<Agendamento, Integer> {
    List<Agendamento> findAll();
}
