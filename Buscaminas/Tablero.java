import excepciones.PosicionInvalida;
import java.util.Random;

public class Tablero {
    private static final int[] EASY_SIZE = {8, 8};
    private static final int EASY_BOMBS = 10;
    private static final int EASY_DIFICULTY = 1;
    private static final int[] MEDIUM_SIZE = {16, 16};
    private static final int MEDIUM_BOMBS = 40;
    private static final int MEDIUM_DIFICULTY = 2;
    private static final int[] HARD_SIZE = {16, 30};
    private static final int HARD_BOMBS = 99;
    private static final int HARD_DIFICULTY = 3;

    private Celda[][] tablero;
    private int bombas;
    private int movimientos;
    private int dificultad;
    
    private Tablero(int[] size, int bombas, int dificultad) {
        this.tablero = new Celda[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                this.tablero[i][j] = new Celda(0);
            }
        }

        this.bombas = bombas;
        this.movimientos = 0;
        this.dificultad = dificultad;
        inicializarTablero();
    }

    public Tablero crearFacil() {
        return new Tablero(EASY_SIZE, EASY_BOMBS, EASY_DIFICULTY);
    }

    public Tablero crearMedio() {
        return new Tablero(MEDIUM_SIZE, MEDIUM_BOMBS, MEDIUM_DIFICULTY);
    }

    public Tablero crearDificil() {
        return new Tablero(HARD_SIZE, HARD_BOMBS, HARD_DIFICULTY);
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
    }

    public void jugar(int x, int y) throws PosicionInvalida {
        
    }
}
