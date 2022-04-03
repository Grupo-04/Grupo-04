package sptech.unlck.horarios.controle;

import sptech.unlck.horarios.entidade.Horario;

public class HorarioControler {

    public static void main(String[] args) {

        Horario hr = new Horario();

        hr.adicionarHorario("10:11");
        hr.adicionarHorario("11:12");
        hr.adicionarHorario("12:13");
        hr.disponibilizarHorario(1,true);
        hr.adicionarHorarioDisponivel("13:14",true);

        hr.exibirHorarios();
        hr.exibirDisponibilidades();
    }
}
