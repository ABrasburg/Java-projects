public class Tablero {
    private int[][] tablero;
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new int[filas][columnas];
    }

    public void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void agregarNumero() {
        int fila = (int) (Math.random() * filas);
        int columna = (int) (Math.random() * columnas);
        while (tablero[fila][columna] != 0) {
            fila = (int) (Math.random() * filas);
            columna = (int) (Math.random() * columnas);
        }
        tablero[fila][columna] = Math.random() < 0.9 ? 2 : 4;
    }

    public boolean moverIzquierda() {
        boolean movimiento = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 1; j < columnas; j++) {
                if (tablero[i][j] != 0) {
                    int k = j;
                    while (k > 0 && tablero[i][k - 1] == 0) {
                        tablero[i][k - 1] = tablero[i][k];
                        tablero[i][k] = 0;
                        k--;
                        movimiento = true;
                    }
                    if (k > 0 && tablero[i][k - 1] == tablero[i][k]) {
                        tablero[i][k - 1] *= 2;
                        tablero[i][k] = 0;
                        movimiento = true;
                    }
                }
            }
        }
        return movimiento;
    }
    public boolean moverDerecha() {
        boolean movimiento = false;
        for (int i = 0; i < filas; i++) {
            for (int j = columnas - 2; j >= 0; j--) {
                if (tablero[i][j] != 0) {
                    int k = j;
                    while (k < columnas - 1 && tablero[i][k + 1] == 0) {
                        tablero[i][k + 1] = tablero[i][k];
                        tablero[i][k] = 0;
                        k++;
                        movimiento = true;
                    }
                    if (k < columnas - 1 && tablero[i][k + 1] == tablero[i][k]) {
                        tablero[i][k + 1] *= 2;
                        tablero[i][k] = 0;
                        movimiento = true;
                    }
                }
            }
        }
        return movimiento;
    }
    public boolean moverArriba() {
        boolean movimiento = false;
        for (int j = 0; j < columnas; j++) {
            for (int i = 1; i < filas; i++) {
                if (tablero[i][j] != 0) {
                    int k = i;
                    while (k > 0 && tablero[k - 1][j] == 0) {
                        tablero[k - 1][j] = tablero[k][j];
                        tablero[k][j] = 0;
                        k--;
                        movimiento = true;
                    }
                    if (k > 0 && tablero[k - 1][j] == tablero[k][j]) {
                        tablero[k - 1][j] *= 2;
                        tablero[k][j] = 0;
                        movimiento = true;
                    }
                }
            }
        }
        return movimiento;
    }
    public boolean moverAbajo() {
        boolean movimiento = false;
        for (int j = 0; j < columnas; j++) {
            for (int i = filas - 2; i >= 0; i--) {
                if (tablero[i][j] != 0) {
                    int k = i;
                    while (k < filas - 1 && tablero[k + 1][j] == 0) {
                        tablero[k + 1][j] = tablero[k][j];
                        tablero[k][j] = 0;
                        k++;
                        movimiento = true;
                    }
                    if (k < filas - 1 && tablero[k + 1][j] == tablero[k][j]) {
                        tablero[k + 1][j] *= 2;
                        tablero[k][j] = 0;
                        movimiento = true;
                    }
                }
            }
        }
        return movimiento;
    }
}