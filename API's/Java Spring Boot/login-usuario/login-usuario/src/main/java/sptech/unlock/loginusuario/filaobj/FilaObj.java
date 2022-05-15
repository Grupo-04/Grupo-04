package sptech.unlock.loginusuario.filaobj;

public class FilaObj<T> {
    // Atributos
    private int tamanho;
    private T[] fila;

    // Construtor
    public FilaObj(int capacidade) {
       this.tamanho = 0;
       this.fila = (T[]) new Object[capacidade];
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        if (this.tamanho == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        if (this.tamanho == this.fila.length) {
            return true;
        } else {
            return false;
        }
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Retornar IllegalStateException caso a fila esteja cheia
     */
    public void insert(T info){
        if (!isFull()) {
            this.fila[tamanho] = info;
            tamanho++;
        } else {
            throw new IllegalStateException();
        }
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public Object peek() {
        return this.fila[0];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
     */
    public Object poll() {
        if (!isEmpty()) {
            T poll = this.fila[0];
            for (int i = 0; i < getTamanho()-1; i++) {
                this.fila[i] = this.fila[i+1];
                this.fila[getTamanho()-1] = null;
            }
            tamanho--;
            return poll;
        } else {
            return -1;
        }
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {
        for (int i = 0; i < getTamanho(); i++) {
            System.out.println(this.fila[i]);
        }
    }

    public int getTamanho(){
        return this.tamanho;
    }
}
