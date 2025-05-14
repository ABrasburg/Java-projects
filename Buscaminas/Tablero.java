import excepciones.PosicionInvalida;
import excepciones.AlreadySelected;
import java.util.Random;

public class Tablero {
    private static final int[] EASY_SIZE = {8, 8};
    private static final int EASY_BOMBS = 10;
    private static final int[] MEDIUM_SIZE = {16, 16};
    private static final int MEDIUM_BOMBS = 40;
    private static final int[] HARD_SIZE = {16, 30};
    private static final int HARD_BOMBS = 99;

    private Celda[][] tablero;
    private int bombas;
    private int movimientos;
    
    private Tablero(int[] size, int bombas) {
        this.tablero = new Celda[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                this.tablero[i][j] = new Celda(0);
            }
        }

        this.bombas = bombas;
        this.movimientos = 0;
        inicializarTablero();
    }

    public Tablero crearFacil() {
        return new Tablero(EASY_SIZE, EASY_BOMBS);
    }

    public Tablero crearMedio() {
        return new Tablero(MEDIUM_SIZE, MEDIUM_BOMBS);
    }

    public Tablero crearDificil() {
        return new Tablero(HARD_SIZE, HARD_BOMBS);
    }

    private void inicializarTablero() {
        int bombasColocadas = 0;
        Random random = new Random();
        while (bombasColocadas < bombas) {
            int x = random.nextInt(tablero.length);
            int y = random.nextInt(tablero[0].length);

            if (!(this.tablero[x][y] instanceof Bomba)) {
                this.tablero[x][y] = new Bomba();
                bombasColocadas++;
            }
        }
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                int bombasVecinas = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (x == 0 && y == 0) continue;
                        int newX = i + x;
                        int newY = j + y;
                        if (newX >= 0 && newX < tablero.length && newY >= 0 && newY < tablero[0].length) {
                            if (this.tablero[newX][newY] instanceof Bomba) {
                                bombasVecinas++;
                            }
                        }
                    }
                }
                tablero[i][j] = new Celda(bombasVecinas);
            }
        }
    }

    public boolean estaGanado() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j].estaEscondida() && !(tablero[i][j] instanceof Bomba)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void jugar(int x, int y) throws PosicionInvalida {
        if (x < 0 || x >= tablero.length || y < 0 || y >= tablero[0].length) {
            throw new PosicionInvalida();
        }
        try {
            if (tablero[x][y].seleccionar()) {
                int [][] direcciones = {{x-1, y-1}, {x-1, y}, {x-1, y+1},
                                        {x, y-1}, {x, y+1},
                                        {x+1, y-1}, {x+1, y}, {x+1, y+1}};
                for (int[] dir : direcciones) {
                    int newX = dir[0];
                    int newY = dir[1];
                    if (newX >= 0 && newX < tablero.length && newY >= 0 && newY < tablero[0].length) {
                        if (tablero[newX][newY].estaEscondida()) {
                            boolean vacio = tablero[newX][newY].seleccionar();
                            if (vacio) {
                                jugar(newX, newY);
                            }
                        }
                    }
                }
            }
            this.movimientos++;
        } catch (AlreadySelected e) {
            
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                sb.append(tablero[i][j].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
