package sptech.unlock.loginusuario.estabelecimento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;

@Component
public interface RepositorioEstabelecimento extends JpaRepository<Estabelecimento, Integer> {

}
