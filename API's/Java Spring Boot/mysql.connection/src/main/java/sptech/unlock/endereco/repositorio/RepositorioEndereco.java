package sptech.unlock.endereco.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import sptech.unlock.endereco.model.Endereco;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RepositorioEndereco extends CrudRepository<Endereco, Integer> {
    List<Endereco> findAll();
}
