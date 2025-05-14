import java.util.Scanner;

public class Main {
    Tablero tablero;
    public Main() {
        tablero = new Tablero(4,4);
    }
    public void iniciarJuego() {
        tablero.inicializarTablero();
        tablero.mostrarTablero();
        while (!tablero.isGameOver()) {
            String movimiento = leerMovimiento();
            switch (movimiento) {
                case "w":
                    tablero.moverArriba();
                    break;
                case "s":
                    tablero.moverAbajo();
                    break;
                case "a":
                    tablero.moverIzquierda();
                    break;
                case "d":
                    tablero.moverDerecha();
                    break;
                default:
                    System.out.println("Movimiento no válido. Usa 'w', 'a', 's' o 'd'.");
            }
            tablero.mostrarTablero();
        }
        System.out.println("¡Juego terminado!");
    }
    public static void main(String[] args) {
        Main juego = new Main();
        juego.iniciarJuego();
    }
    private String leerMovimiento() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce tu movimiento (w/a/s/d): ");
            String movimiento = scanner.nextLine();
            while (!movimiento.matches("[wasd]")) {
                System.out.print("Movimiento no válido. Introduce 'w', 'a', 's' o 'd': ");
                movimiento = scanner.nextLine();
            }
            return movimiento;
        }
    }
}
