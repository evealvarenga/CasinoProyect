package casino;
import javax.swing.JOptionPane;

public class Adivina extends Juegos {

    public Adivina() {
    	super(10);
        
    }

	public void jugar(Cliente cliente, double apuestaInicial) {
		
		do {
			// Solicita una carta entre 1 y 13 para el jugador
	    	int cartaJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de su carta.\nRecuerde que debe ser entre 1 a 13."));

	        // Genera una carta entre 1 y 13 para la banca. Random desde la clase Juego.
	        int cartaBanca = Juegos.valorRandom(13);

	        String mensaje = "Carta del jugador: " + cartaJugador + "\nCarta de la banca: " + cartaBanca;

	        if (cartaJugador > cartaBanca) {
	        	double ganancia = apuestaInicial * 2;
	        	cliente.setFichasActuales(cliente.getFichasActuales() + ganancia);
	            System.out.println("¡Ganaste!");
	        }
	        else if (cartaJugador < cartaBanca) {
	        	cliente.setFichasActuales(cliente.getFichasActuales() - apuestaInicial);
	            System.out.println("Perdiste.");
	        }
	        else {
	            System.out.println("Empate.");
	        }
	        
	        JOptionPane.showConfirmDialog(null, "¿Deseas retirarte?");
		} while (apuestaInicial!=0);

        
    }
    
}