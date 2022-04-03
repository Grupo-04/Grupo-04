package sptech.unlck.horarios.entidade;

import java.util.ArrayList;
import java.util.List;

/*GET DE HORARIOS OCUPADOS DO RESTAURANTE*/
public class Horario {

    private List<String> horarios;
    private List<Boolean> disponiveis;

    public Horario() {
        this.horarios = new ArrayList<>();
        this.disponiveis = new ArrayList<>();
    }

    public void adicionarHorario(String horario){
        horarios.add(horario);
        disponiveis.add(false);
    }

    public void disponibilizarHorario(int indice,Boolean disponivel){
        disponiveis.set(indice,disponivel);
    }

    public void adicionarHorarioDisponivel(String horario, Boolean disponivel){
        horarios.add(horario);
        disponiveis.add(disponivel);
    }

    public void exibirHorarios(){
        for (String hor : horarios){
            System.out.print(hor+"\t");
        }
        System.out.println();
    }

    public void exibirDisponibilidades(){
        for (Boolean disp : disponiveis){
            System.out.print(disp+"\t");
        }
        System.out.println();
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }

    public List<Boolean> getDisponiveis() {
        return disponiveis;
    }

    public void setDisponiveis(List<Boolean> disponiveis) {
        this.disponiveis = disponiveis;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "horarios=" + horarios +
                ", disponiveis=" + disponiveis +
                '}';
    }
}
