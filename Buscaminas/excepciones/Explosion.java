package excepciones;

public class Explosion extends RuntimeException {
    public Explosion() {
        super("Perdiste!");
    }
}
