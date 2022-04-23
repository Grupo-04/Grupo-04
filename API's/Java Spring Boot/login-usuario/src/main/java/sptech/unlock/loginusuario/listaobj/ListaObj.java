package sptech.unlock.loginusuario.listaobj;

public class ListaObj<T> {

    private T[] vetor;
    private int numeroElemento;

    public T[] getVetor() {
        return vetor;
    }

    public int getNumeroElemento() {
        return numeroElemento;
    }

    public ListaObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.numeroElemento = 0;
    }

    public void adiciona(T novoElemento) {
        if (numeroElemento >= vetor.length) {
            System.out.println("Lista cheia!");
        } else {
            vetor[numeroElemento++] = novoElemento;
        }
    }

    public void adicionarNoMeio(T novoElemento) {
        if (numeroElemento >= vetor.length) {
            System.out.println("Lista cheia!");
        } else {
            int meio = numeroElemento / 2;
            adicionarNoIndice(novoElemento, meio);
        }
    }

    public void exibir() {
        for (int i = 0; i < numeroElemento; i++) {
            System.out.println(String.format("V[%d] = %s", i, vetor[i]));
        }
    }

    public int buscarIndice(int indice) {
        if (indice < 0 || indice >= numeroElemento) {
            return -1;
        }
        return 1;
    }

    public boolean removerPeloIndice(int indiceRemover) {
        if (indiceRemover >= numeroElemento || indiceRemover < 0) {
            System.out.println("Índice inexistente!");
            return false;
        }

        for (int i = indiceRemover; i < numeroElemento - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        numeroElemento--;

        return true;
    }

    public boolean removeElemento(int elementoRemover) {

        if (removerPeloIndice(buscarIndice(elementoRemover))) {
            return true;
        } else {
            return false;
        }

    }

    public boolean substituir(T valorAntigo, T valorNovo) {
        for (int i = 0; i < numeroElemento; i++) {
            if (vetor[i].equals(valorAntigo)) {
                vetor[i] = valorNovo;
                return true;
            }
        }
        return false;
    }

    public int contarOcorrencias(T valorProcurado) {
        int ocorrencias = 0;
        for (int i = 0; i < numeroElemento; i++) {
            if (vetor[i].equals(valorProcurado)) {
                ocorrencias++;
            }
        }
        return ocorrencias;
    }

    public void adicionarNoInicio(T novoValor) {
        if (numeroElemento >= vetor.length) {
            System.out.println("Lista cheia!!!");
        } else {
            int j = 0;
            for (int i = numeroElemento; i > 0; i--) {
                j = i - 1;
                vetor[i] = vetor[j];
            }
            numeroElemento++;
            vetor[0] = novoValor;
        }
    }

    //LISTA OBJ NEW METHODS
    public int getTamanho() {
        return vetor.length;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= numeroElemento) {
            return null;
        } else {
            return vetor[indice];
        }
    }

    public void limpa() {
        numeroElemento = 0;
    }

    public void adicionarNoIndice(T novoValor, int indice) {
        if (numeroElemento >= vetor.length) {
            System.out.println("Lista cheia!!!");
        } else {
            int j = 0;
            for (int i = numeroElemento; i > indice; i--) {
                j = i - 1;
                vetor[i] = vetor[j];
            }
            numeroElemento++;
            vetor[indice] = novoValor;
        }
    }
}
