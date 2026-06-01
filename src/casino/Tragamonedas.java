package casino;

import javax.swing.JOptionPane;
import java.util.Random;

public class Tragamonedas {

    // 1. COMPONENTES DEL JUEGO
    private static final int FILAS = 3;
    private static final int COLUMNAS = 5;
    private static final int COSTO_TURNO = 10; // El costo fijo y único por jugar

    // Símbolos (Emojis)
    private static final String CEREZA = "🍒";   // Muy común
    private static final String CAMPANA = "🔔";  // Raro
    private static final String DIAMANTE = "💎"; // Muy raro (Jackpot)
    private static final String WILD = "🃏";     // Comodín
    private static final String SCATTER = "🌟";  // Dispersión

    // Lista de pesos para simular la probabilidad
    private static final String[] POOL_SIMBOLOS = {
        CEREZA, CEREZA, CEREZA, CEREZA, CEREZA, CEREZA, CEREZA, CEREZA,
        CAMPANA, CAMPANA, CAMPANA, CAMPANA,
        WILD, WILD,
        SCATTER, SCATTER,
        DIAMANTE
    };

    private String[][] matriz = new String[FILAS][COLUMNAS];
    private int saldo = 1000; // Saldo inicial del jugador
    private Random random = new Random();

    public static void main(String[] args) {
        Tragamonedas juego = new Tragamonedas();
        juego.iniciarJuego();
    }

    public void iniciarJuego() {
        JOptionPane.showMessageDialog(null, 
            "🎰 ¡Bienvenido a la Tragamonedas Java! 🎰\n" +
            "Saldo Inicial: $" + saldo + "\n" +
            "💵 Costo por giro: $" + COSTO_TURNO + " fijos.\n\n" +
            "Tabla de Premios (Línea Central):\n" +
            "🍒 Fila Central: +$50\n" +
            "🔔 Fila Central: +$200\n" +
            "🃏 Fila Central (Pura): +$500\n" +
            "💎 Fila Central: +$1000 ¡JACKPOT!\n\n" +
            "🌟 Scatter: ¡Paga $1 por cada uno en cualquier posición!", 
            "Casino Royal", JOptionPane.INFORMATION_MESSAGE);

        while (saldo >= COSTO_TURNO) {
            // Opciones de interacción por botones
            String[] opciones = {"Girar Rodillos 🎰", "Salir del Juego 🚪"};
            
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Saldo actual: $" + saldo + "\nCosto por giro: $" + COSTO_TURNO + "\n\n¿Qué deseas hacer?",
                    "Panel de Control",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            // Si presiona "Salir del Juego" o cierra la ventana, se rompe el bucle
            if (seleccion == 1 || seleccion == JOptionPane.CLOSED_OPTION) {
                break;
            }

            // Descontar automáticamente el costo fijo del turno
            saldo -= COSTO_TURNO;

            // Ejecutar la jugada
            girarRodillos();
            mostrarYVerificar();
        }

        // Si el bucle termina porque se quedó sin dinero
        if (saldo < COSTO_TURNO) {
            JOptionPane.showMessageDialog(null, 
                "❌ Te has quedado sin saldo suficiente para pagar el giro ($" + COSTO_TURNO + ").\n" +
                "Saldo final: $" + saldo, 
                "Fin del Juego", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                "🚪 Has abandonado la partida.\n" +
                "Te llevas un saldo total de: $" + saldo, 
                "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 2. EL GIRO (The Spin)
    private void girarRodillos() {
        for (int f = 0; f < FILAS; f++) {
            for (int c = 0; c < COLUMNAS; c++) {
                int indiceAzar = random.nextInt(POOL_SIMBOLOS.length);
                matriz[f][c] = POOL_SIMBOLOS[indiceAzar];
            }
        }
    }

    // 3. VERIFICACIÓN DE GANANCIAS Y PAGO
    private void mostrarYVerificar() {
        StringBuilder visualMatriz = new StringBuilder();
        visualMatriz.append("  [ RODILLOS ]\n");
        for (int f = 0; f < FILAS; f++) {
            visualMatriz.append(" | ");
            for (int c = 0; c < COLUMNAS; c++) {
                visualMatriz.append(matriz[f][c]).append(" | ");
            }
            if (f == 1) visualMatriz.append("  ⬅️ LÍNEA CENTRAL");
            visualMatriz.append("\n");
        }
        visualMatriz.append("\n");

        int premioTotal = 0;

        // --- A. Línea Recta (Fila Central = Índice 1) ---
        boolean lineaGanadora = true;
        String primerSimbolo = matriz[1][0];
        
        if (primerSimbolo.equals(WILD)) {
            for (int c = 1; c < COLUMNAS; c++) {
                if (!matriz[1][c].equals(WILD)) {
                    primerSimbolo = matriz[1][c];
                    break;
                }
            }
        }

        for (int c = 0; c < COLUMNAS; c++) {
            String simboloActual = matriz[1][c];
            if (!simboloActual.equals(primerSimbolo) && !simboloActual.equals(WILD)) {
                lineaGanadora = false;
                break;
            }
        }

        if (lineaGanadora && !primerSimbolo.equals(SCATTER)) {
            int premioLinea = 0;
            switch (primerSimbolo) {
                case CEREZA: premioLinea = 50; break;   // Equivalente a apuesta 10 * 5
                case CAMPANA: premioLinea = 200; break; // Equivalente a apuesta 10 * 20
                case DIAMANTE: premioLinea = 1000; break; // Equivalente a apuesta 10 * 100
                case WILD: premioLinea = 500; break;    // Línea pura de Comodines
            }
            premioTotal += premioLinea;
            visualMatriz.append("🎉 ¡LÍNEA GANADORA en el centro con ").append(primerSimbolo).append("! 🎉\n");
        }

        // --- B. Scatter (Dispersión) ---
        int contadorScatters = 0;
        for (int f = 0; f < FILAS; f++) {
            for (int c = 0; c < COLUMNAS; c++) {
                if (matriz[f][c].equals(SCATTER)) {
                    contadorScatters++;
                }
            }
        }

        if (contadorScatters > 0) {
            int premioScatter = contadorScatters * 1; // Paga $1 directo por cada estrella
            premioTotal += premioScatter;
            visualMatriz.append("🌟 ¡Aparecieron ").append(contadorScatters).append(" Scatters! Ganaste: $").append(premioScatter).append("\n");
        }

        // --- C. Resultado final de la ronda ---
        if (premioTotal > 0) {
            saldo += premioTotal;
            visualMatriz.append("\n💰 ¡Ganancia de este giro: +$").append(premioTotal).append("!");
        } else {
            visualMatriz.append("\n❌ Sin premios en este giro.");
        }

        JOptionPane.showMessageDialog(null, visualMatriz.toString(), "Resultado del Giro", JOptionPane.INFORMATION_MESSAGE);
    }
}