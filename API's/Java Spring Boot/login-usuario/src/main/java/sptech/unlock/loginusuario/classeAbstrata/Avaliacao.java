package sptech.unlock.loginusuario.classeAbstrata;

//import sptech.unlock.loginusuario.agendamento.entidade.Agendamento;

public abstract class Avaliacao {

    private Integer id;
    private Double nota;
    private String comentario;

//    public abstract void avaliar(Agendamento a, Double nota, String comentario);
    public abstract void atualizar(Avaliacao a);

}
