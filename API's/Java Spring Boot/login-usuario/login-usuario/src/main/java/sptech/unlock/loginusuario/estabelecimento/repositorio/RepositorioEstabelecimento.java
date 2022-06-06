package sptech.unlock.loginusuario.estabelecimento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;

import java.util.List;

@Component
public interface RepositorioEstabelecimento extends JpaRepository<Estabelecimento, Integer> {
    Estabelecimento findById(int id);
    Estabelecimento findByEmailAndSenha(String email, String senha);

    @Query("select a from Estabelecimento a where a.interesse_match_cidade=?1 and a.endereco.cidade=?2")
    List<Estabelecimento> consultaInteresseMatchCidadeAndEnderecoCidade(boolean interessado, String cidade);

    @Query("select a from Estabelecimento a where a.interesse_match_cidade=?1")
    List<Estabelecimento> consultaInteressadosMatchCidade(boolean interessado);

}
