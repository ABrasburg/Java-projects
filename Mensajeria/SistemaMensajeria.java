package Mensajeria;
import java.util.List;
import java.util.ArrayList;

public class SistemaMensajeria {
    private List<Usuario> usuarios;

    public SistemaMensajeria() {
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public void enviarMensaje(String contenido, String emisorNombre, String receptorNombre) {
        Usuario emisor = buscarUsuario(emisorNombre);
        Usuario receptor = buscarUsuario(receptorNombre);

        if (emisor != null && receptor != null) {
            Mensaje mensaje = new Mensaje(contenido, emisor);
            receptor.recibirMensaje(mensaje);
        } else {
            System.out.println("Error: Usuario no encontrado.");
        }
    }
}
