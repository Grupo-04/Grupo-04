package sptech.mysql.connection;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RepositorioEndereco extends CrudRepository<Endereco, Integer> {
    List<Endereco> findAll();
}
