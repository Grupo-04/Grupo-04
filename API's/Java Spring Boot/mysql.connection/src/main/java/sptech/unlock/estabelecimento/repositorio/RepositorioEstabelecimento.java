package sptech.unlock.estabelecimento.repositorio;

import org.springframework.data.repository.CrudRepository;
import sptech.unlock.estabelecimento.model.Estabelecimento;

import java.util.List;

public interface RepositorioEstabelecimento extends CrudRepository<Estabelecimento, Integer> {
    List<Estabelecimento> findAll();
}
