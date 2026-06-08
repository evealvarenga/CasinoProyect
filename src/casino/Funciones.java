package casino;

import javax.swing.JOptionPane;

public class Funciones {
	public static Integer validarNumero(String tipo) {
		Integer numero = null;
	    String input;
	    do {
	        input = JOptionPane.showInputDialog("Ingrese número de " + tipo + ":");

	        if (input == null) {
	            return null;
	        }
	        if (input.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No puede dejar el campo vacío.");
	            continue;
	        }
	        try {
	            numero = Integer.parseInt(input);
	            if(numero <0) {
	            	JOptionPane.showMessageDialog(null, "Ingresó un número no valido. Intente nuevamente.");
	            	return null;
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Ingrese solo números.");
	        }
	    } while (numero == null);
	    return numero;
	}
	
	public static Integer validarNumero() {
		Integer numero = null;
	    String input;
	    do {
	        input = JOptionPane.showInputDialog("Ingrese número de :");

	        if (input == null) {
	            return null;
	        }
	        if (input.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No puede dejar el campo vacío.");
	            continue;
	        }
	        try {
	            numero = Integer.parseInt(input);
	            if(numero <0) {
	            	JOptionPane.showMessageDialog(null, "Ingresó un número no valido. Intente nuevamente.");
	            	return null;
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Ingrese solo números.");
	        }
	    } while (numero == null);
	    return numero;
	}
	
	public static boolean puedeJugar(Cliente cliente, Juegos juego) {
	    return cliente.getFichasActuales() >= juego.getApuestaMinima();
	}
}
