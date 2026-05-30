package casino;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
	static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	static ArrayList<Cliente> listaCliente = new ArrayList<>();
	static ArrayList<Gerente> listaGerente = new ArrayList<>();

	public static void main(String[] args) {	
		Seed.cargarEmpleados(listaEmpleados);
		Seed.cargarClientes(listaCliente);
		Seed.cargarGerente(listaGerente);
		
	
		//Inicio del programa
		JOptionPane.showMessageDialog(null, "------------ Bienvenido al casino ---------");
		validacionUsuario();
	}	
		public static void validacionUsuario() {
			Monedero banco = Seed.cargarBanca();
			Integer documento = 0;
			do {
				documento = Funciones.validarNumero("documento");
				//if (documento == null) return null;
				Cliente clienteEncontrado = null;
				for (Cliente d : listaCliente) {
			        if (d.getDni() == documento) {
			        	clienteEncontrado = d;
			            JOptionPane.showMessageDialog(null, "¡Bienvenido, " + clienteEncontrado.getNombreCompleto() + "!");
			            interfazCliente(clienteEncontrado);
			            return;
			        }
			    }
			    Empleado empleadoEncontrado = null;
				for (Empleado d : listaEmpleados) {
			        if (d.getDni() == documento) {
			        	empleadoEncontrado = d;
			            JOptionPane.showMessageDialog(null, "¡Bienvenido, " + empleadoEncontrado.getNombreCompleto() + "!");
			            interfazEmpleado(empleadoEncontrado);
			            return;
			        }
			    }
			    
			    Gerente gerenteEncontrado = null;
				for (Gerente d : listaGerente) {
			        if (d.getDni() == documento) {
			        	gerenteEncontrado = d;
			            JOptionPane.showMessageDialog(null, "¡Bienvenido, " + gerenteEncontrado.getNombreCompleto() + "!");
			            interfazGerente(gerenteEncontrado, banco);
			            return;
			        }
			    }
				nuevoCliente(documento);
			} while (documento == 0 || documento == null);	
		}
		
		public static void nuevoCliente(Integer documento) {
			String nombre = JOptionPane.showInputDialog("Ingresar nombre completo.");
			//if (nombre == null || nombre.trim().isEmpty()) return null;
			String direccion = JOptionPane.showInputDialog("Ingresar dirección completa.");
			int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingresar número de teléfono"));
			String email = JOptionPane.showInputDialog("Ingresar el e-mail.");
			Cliente nuevo = new Cliente(documento, nombre, direccion, telefono, email);
			listaCliente.add(nuevo);
			JOptionPane.showConfirmDialog(null, "¡Cuenta generada correctamente! \n¡Bienvenido, "+nombre+"!");
		}
		
		public static void interfazCliente(Cliente cliente) {
			JOptionPane.showMessageDialog(null, "Interfaz Cliente");
			
			return;
		}
		
		public static void interfazEmpleado(Empleado empleado) {
			JOptionPane.showMessageDialog(null, "Interfaz Empleado");
			return;
		}
		
		public static void interfazGerente(Gerente gerente, Monedero banco) {
			String[] opciones0 = {"Registrar nuevo empleado", "Verificar ganancias del Banco", "Salir"};
			int eleccion0;
			do {
				eleccion0 = JOptionPane.showOptionDialog(null, "Ingresó como Gerente.\nSeleccione una operación", "Casino",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
	                    null, opciones0, opciones0[0]
	            );
	            switch (eleccion0) {
	                //case 0: generarEmpleado(); break;
	                case 1: gerente.verificarGanacias(banco); return;
	            }
			} while (eleccion0 != 2 && eleccion0 != -1);
		
			/*public static void generarEmpleado() {
				JOptionPane.showInputDialog("Ingresa el número de DNI");
			};*/
			return;
			
		}
		
		
		
	

}
