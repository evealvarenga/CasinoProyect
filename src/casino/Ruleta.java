package casino;
import java.util.Random;

public class Ruleta {
   
    private final NumeroRuleta[] casillas;
    private final Random random;

    public Ruleta() {
        this.casillas = new NumeroRuleta[37];
        this.random = new Random();
        inicializarMesa(); // Llamamos al método interno para construir los objetos 
    }

    
    private void inicializarMesa() {
        for (int i = 0; i <= 36; i++) {
            String color;

            if (i == 0) {
                color = "Verde";
            } 
            // Bloque A: 1-10 y 19-28
            
            else if ((i >= 1 && i <= 10) || (i >= 19 && i <= 28)) {
                color = (i % 2 == 0) ? "Negro" : "Rojo";
            } 
            
            // Bloque B: 11-18 y 29-36
            else {
                color = (i % 2 == 0) ? "Rojo" : "Negro";
            }
            
            casillas[i] = new NumeroRuleta(i, color);
        }
    }

    public NumeroRuleta girar() {
        int indiceAleatorio = random.nextInt(37); 
        return casillas[indiceAleatorio];
    }
}