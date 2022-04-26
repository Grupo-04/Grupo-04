package sptech.unlock.loginusuario.classeAbstrata;

//import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;

import javax.persistence.*;

@MappedSuperclass
public abstract class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Double nota;
    private String comentario;

    private Integer fk_agendamento;

    public Avaliacao() {
    }

    public Avaliacao(Integer id, Double nota, String comentario, Integer fk_agendamento) {
        this.id = id;
        this.nota = nota;
        this.comentario = comentario;
        this.fk_agendamento = fk_agendamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getFk_agendamento() {
        return fk_agendamento;
    }

    public void setFk_agendamento(Integer fk_agendamento) {
        this.fk_agendamento = fk_agendamento;
    }
}
