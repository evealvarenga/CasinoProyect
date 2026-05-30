package casino;

import javax.swing.JOptionPane;

public class Gerente extends Persona {
	
    public Gerente(int dni, String nombreCompleto, String domicilio, int telefono, String mail) {
    super(dni, nombreCompleto, domicilio, telefono, mail, "GERENTE");
    }
	
	
	//Funciones
	
	public void verReporteCliente() {
		
	}
	
	public void generarEmpleado(Cliente cliente) {
		cliente.setRango("EMPLEADO");
		JOptionPane.showConfirmDialog(null, "Empleado generado con éxito.");
		
	}
	
	public void verificarGanacias(Monedero banca) {
		banca.mostrarSaldoTotal();
	}
}
