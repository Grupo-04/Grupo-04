package sptech.unlock.loginusuario.estabelecimento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sptech.unlock.loginusuario.classeAbstrata.Usuario;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;

import java.util.List;

@Component
public interface RepositorioEstabelecimento extends JpaRepository<Estabelecimento, Integer> {

}
