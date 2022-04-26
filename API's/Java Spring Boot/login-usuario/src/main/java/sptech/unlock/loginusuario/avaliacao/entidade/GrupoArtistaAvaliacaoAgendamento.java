package sptech.unlock.loginusuario.avaliacao.entidade;

import sptech.unlock.loginusuario.classeAbstrata.Avaliacao;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_artista_avaliacao_agendamento")
public class GrupoArtistaAvaliacaoAgendamento extends Avaliacao {

    public GrupoArtistaAvaliacaoAgendamento() {
    }

    public GrupoArtistaAvaliacaoAgendamento(Integer id, Double nota, String comentario, Integer fk_agendamento) {
        super(id, nota, comentario, fk_agendamento);
    }
}
