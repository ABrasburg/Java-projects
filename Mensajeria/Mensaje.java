package Mensajeria;

public class Mensaje {
    private String contenido;
    Usuario emisor;

    public Mensaje(String contenido, Usuario emisor) {
        this.contenido = contenido;
        this.emisor = emisor;
    }

    public String getContenido() {
        return contenido;
    }

    public Usuario getEmisor() {
        return emisor;
    }
}
