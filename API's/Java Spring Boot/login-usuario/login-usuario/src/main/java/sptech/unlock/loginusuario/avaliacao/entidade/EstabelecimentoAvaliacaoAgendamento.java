package sptech.unlock.loginusuario.avaliacao.entidade;

import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;
import sptech.unlock.loginusuario.classeAbstrata.Avaliacao;
import sptech.unlock.loginusuario.estabelecimento.entidade.Estabelecimento;

import javax.persistence.*;

@Entity
@Table(name = "estabelecimento_avaliacao_agendamento")
public class EstabelecimentoAvaliacaoAgendamento extends Avaliacao {

    public EstabelecimentoAvaliacaoAgendamento() {
    }

    public EstabelecimentoAvaliacaoAgendamento(Integer id, Double nota, String comentario, Integer fk_agendamento, Estabelecimento estabelecimento, Agendamento agendamento) {
        super(id, nota, comentario, fk_agendamento);
    }
}
