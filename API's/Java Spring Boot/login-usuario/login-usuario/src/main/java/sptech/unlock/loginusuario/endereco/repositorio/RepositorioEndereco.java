package sptech.unlock.loginusuario.endereco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.loginusuario.endereco.entidade.Endereco;

import java.util.List;

public interface RepositorioEndereco extends JpaRepository<Endereco, Integer> {

}
