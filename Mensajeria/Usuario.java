package Mensajeria;
import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String nombre;
    List<Mensaje> mensajesRecibidos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.mensajesRecibidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void recibirMensaje(Mensaje mensaje) {
        mensajesRecibidos.add(mensaje);
    }

    public void mostrarMensajes() {
        System.out.println("Mensajes recibidos por " + nombre + ":");
        for (int i = 0; i < mensajesRecibidos.size(); i++) {
            Mensaje mensaje = mensajesRecibidos.get(i);
            System.out.println(mensaje);
        }
    }
}
