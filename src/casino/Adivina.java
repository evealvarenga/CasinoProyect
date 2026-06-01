package casino;
import javax.swing.JOptionPane;

public class Adivina extends Juegos {

    public Adivina() {
    	super(10);
        
    }

	public void jugar(Cliente cliente) {
		int respuesta = JOptionPane.NO_OPTION;
		
		do {
			double apuesta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de su apuesta.\nTenga en cuenta que tiene " + cliente.getFichasActuales() + " fichas disponibles para apostar."));
			// Solicita una carta entre 1 y 13 para el jugador
	    	int cartaJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de su carta.\nRecuerde que debe ser entre 1 a 13."));

	        // Genera una carta entre 1 y 13 para la banca. Random desde la clase Juego.
	        int cartaBanca = Juegos.valorRandom(13);

	        String mensaje = "Carta del jugador: " + cartaJugador + "\nCarta de la banca: " + cartaBanca;

	        if (cartaJugador > cartaBanca) {
	        	double ganancia = apuesta * 2;
	        	cliente.setFichasActuales(cliente.getFichasActuales() + ganancia);
	        	JOptionPane.showMessageDialog(null, mensaje + "\n¡Ganó la apuesta!");
	        }
	        else if (cartaJugador < cartaBanca) {
	        	cliente.setFichasActuales(cliente.getFichasActuales() - apuesta);
	        	JOptionPane.showMessageDialog(null, mensaje + "\n¡Mala suerte! No ganó la apuesta.");
	        }
	        else {
	            System.out.println("Empate.");
	        }
	        			
			respuesta = JOptionPane.showConfirmDialog(
				    null, 
				    "¿Querés continuar apostando?", 
				    "Confirmación", 
				    JOptionPane.YES_NO_OPTION
				);

				if (respuesta == JOptionPane.NO_OPTION) {
				    return;
				} 
		} while (respuesta != JOptionPane.NO_OPTION);
		        
    }
    
}