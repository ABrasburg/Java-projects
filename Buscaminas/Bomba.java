import excepciones.AlreadySelected;
import excepciones.Explosion;

public class Bomba extends Celda {
    public Bomba() {
        super(0);
    }
    @Override
    public boolean seleccionar() throws AlreadySelected {
        throw new Explosion();
    }
}