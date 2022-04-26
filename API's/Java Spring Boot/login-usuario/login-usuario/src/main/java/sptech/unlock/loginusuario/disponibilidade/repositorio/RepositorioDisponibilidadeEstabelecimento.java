package sptech.unlock.loginusuario.disponibilidade.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.loginusuario.disponibilidade.entidade.DisponibilidadeEstabelecimento;

import java.util.List;

public interface RepositorioDisponibilidadeEstabelecimento extends JpaRepository<DisponibilidadeEstabelecimento, Integer> {
    List<DisponibilidadeEstabelecimento> findAll();
}
