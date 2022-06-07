package sptech.unlock.loginusuario.recuperarSenha;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCodigo extends JpaRepository<Codigo, Integer> {

    boolean existsByIdArtista(Integer idArtista);

    Codigo findByIdArtista(Integer idArtista);

}
