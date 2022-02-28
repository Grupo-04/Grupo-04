package sptech.mysql.connection;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioEstabelecimento extends CrudRepository<Estabelecimento, Integer> {
    List<Estabelecimento> findAll();
}
