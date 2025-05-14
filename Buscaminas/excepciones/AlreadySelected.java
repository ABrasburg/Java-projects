package excepciones;

public class AlreadySelected extends Exception {
    public AlreadySelected() {
        super("La celda ya ha sido seleccionada.");
    }
}