package sptech.unlock.loginusuario.interfaces;

public interface Avaliavel<E,V> {
    public abstract E avaliar(V a);
    public abstract E atualizar(Integer id, V a);
}
