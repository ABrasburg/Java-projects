public class Tablero {
    private int[][] tablero;
    private int filas;
    private int columnas;

    public Tablero() {
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

    

}