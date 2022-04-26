package sptech.unlock.loginusuario.email.model;

public class Email {

    private String destinatario;
    private String titulo;
    private String texto;

    public Email(String destinatario, String titulo, String texto) {
        this.destinatario = destinatario;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Email() {}

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return String.format(
                "Destinatário: %s\nTítulo: %s\nTexto: %s",
                this.destinatario,
                this.titulo,
                this.texto);
    }
}
