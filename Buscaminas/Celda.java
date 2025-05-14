import excepciones.AlreadySelected;

public class Celda {
    private int bombasVecinas;
    private boolean escondida;

    public Celda(int cantBombas) {
        this.bombasVecinas = cantBombas;
        this.escondida = true;
    }

    public boolean seleccionar() throws AlreadySelected{
        if (!this.escondida) throw new AlreadySelected();
        this.escondida = false;
        return this.bombasVecinas == 0;
    }

    public boolean estaEscondida() {
        return this.escondida;
    }

    @Override
    public String toString() {
        return escondida ? "[X]" : "[" + bombasVecinas + "]";
    }
}
