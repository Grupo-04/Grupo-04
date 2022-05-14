package sptech.unlock.loginusuario.pilhaobj;

public class PilhaObj <T> {

    private int topo;
    private T[] pilha;

    public PilhaObj(int capacidade) {
        this.topo = -1;
        this.pilha = (T[]) new Object[capacidade];
    }

    public boolean isEmpty(){
        if (topo == -1) {
            return true;
        } else {
            return false;
        }
    }

    //public boolean isEmpty(){
    // return topo == -1;
    // }

    public boolean isFull(){
        if (topo == (pilha.length - 1)) {
            return true;
        } else {
            return false;
        }
    }

    //public boolean isFull(){
    // return topo == pilha.lenght - 1;
    // return topo + 1 == pilha.lenght;
    // }

    public void push(T info) {
        if (!isFull()) {
            pilha[++topo] = info;
        } else {
            System.out.println("Pilha cheia!");
        }
    }

    public Object pop() {
        if (!isEmpty()) {
            return (T) pilha[topo--];
        } else {
            return -1;
        }
    }

    public Object peek() {
        if (!isEmpty()) {
            return (T) pilha[topo];
        } else {
            return -1;
        }
    }

    public void exibe(){
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.print(pilha[i]);
            }
        }
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }

    public T[] getPilha() {
        return pilha;
    }

    public void setPilha(T[] pilha) {
        this.pilha = pilha;
    }
}
