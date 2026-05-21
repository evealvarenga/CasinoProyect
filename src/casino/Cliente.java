package casino;

import javax.swing.JOptionPane;

public class Cliente extends Persona {
	private double fichasActuales;
	
    public Cliente(int dni, String nombreCompleto, String domicilio, int telefono, String mail) {
    super(dni, nombreCompleto, domicilio, telefono, mail, "CLIENTE");
    this.fichasActuales = 0;
    }
	
	
	//GETTERS Y SETTERS
    public double getFichasActuales() {return fichasActuales;}

	public void setFichasActuales(double fichasActuales) {this.fichasActuales = fichasActuales;}
    
	
	public String mostrarDatos() {
        return Cliente.super.getNombreCompleto() + "\nNúmero de documento: " + Cliente.super.getDni() + "\nDomicilio registrado: " + Cliente.super.getDomicilio() + "\nTeléfono: " + Cliente.super.getTelefono();
	}
	
	public void comprarFichas() {
		Double importe = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero: "));
		//Falta validador
		//Función de monedero
		//setfichasActuales(importe);
	}
	
	public void jugar(){
		
		
	}
	
	public void gestionarPerfil() {
		
	}
	
	public void verStatusFichas() {
		
	}
}
