package sptech.unlock.pesquisanome.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.unlock.pesquisanome.entidade.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {
}
