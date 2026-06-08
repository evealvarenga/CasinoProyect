package casino;

import javax.swing.JOptionPane;

public class Dados extends Juegos{
	
	public Dados() {
		super(10);
	}
	
	public void jugar(Cliente cliente) {
		int respuesta = JOptionPane.NO_OPTION;
		
		do {
			double apuesta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de su apuesta.\nTenga en cuenta que tiene " + cliente.getFichasActuales() + " fichas disponibles para apostar."));
			int dado1 = Juegos.valorRandom(6);
			int dado2 = Juegos.valorRandom(6);
			int suma = dado1 + dado2;
			
			String mensaje = "El valor del dado 1 es de "+dado1+" y el valor del dado 2 es de "+dado2 +".\nLa suma es de "+suma;
			
			switch (suma) {
			case 7,11: {
				double ganancia = apuesta * 2;
	        	cliente.setFichasActuales(cliente.getFichasActuales() + ganancia);
	        	JOptionPane.showMessageDialog(null, mensaje + "\n¡Ganó la apuesta!");
				break;
			}
			case 2,3,12:{
	        	cliente.setFichasActuales(cliente.getFichasActuales() - apuesta);
	        	JOptionPane.showMessageDialog(null, mensaje + "\n¡Mala suerte! No ganó la apuesta.");
				break;
			}
			case 4,5,6,8,9,10:{
				int punto = suma;
				boolean finalizar = false;
				do {
					int nuevaSuma = Juegos.valorRandom(12);
					if(nuevaSuma == punto) {
						double ganancia = apuesta * 2;
			        	cliente.setFichasActuales(cliente.getFichasActuales() + ganancia);
			        	JOptionPane.showMessageDialog(null, mensaje + "\n¡Ganó la apuesta!");
						break;
					} else if(nuevaSuma == 7){
						cliente.setFichasActuales(cliente.getFichasActuales() - apuesta);
			        	JOptionPane.showMessageDialog(null, mensaje + "\n¡Mala suerte! No ganó la apuesta.");
						break;
					}
				} while (finalizar == false);
				break;
				}
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
