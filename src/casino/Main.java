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
		
		System.out.println(listaCliente);
	
		//Inicio del programa
		JOptionPane.showMessageDialog(null, "------------ Bienvenido al casino ---------");
		validacionUsuario();
	}	
		public static void validacionUsuario() {
			Monedero banco = Seed.cargarBanca();
			Integer documento = 0;
			do {
				documento = Funciones.validarNumero("documento");
				if (documento == null) return;
				
				for (Cliente c : listaCliente) {
			        if (c.getDni() == documento) {
			            JOptionPane.showMessageDialog(null, "¡Bienvenido, " + c.getNombreCompleto() + "!");
			            interfazCliente(c);
			            return;
			        }
			    }
				for (Empleado e : listaEmpleados) {
			        if (e.getDni() == documento) {
			            JOptionPane.showMessageDialog(null, "¡Bienvenido, " + e.getNombreCompleto() + "!");
			            interfazEmpleado(e);
			            return;
			        }
			    }
			    
				for (Gerente g : listaGerente) {
			        if (g.getDni() == documento) {
			            JOptionPane.showMessageDialog(null, "¡Bienvenido, " + g.getNombreCompleto() + "!");
			            interfazGerente(g, banco);
			            return;
			        }
			    }
				nuevoCliente(documento);
			} while (documento == null || documento == 0);	
		}
		
		public static void nuevoCliente(Integer documento) {
			String nombre = JOptionPane.showInputDialog("Ingresar nombre completo.");
			if (nombre == null || nombre.trim().isEmpty()) return;
			String direccion = JOptionPane.showInputDialog("Ingresar dirección completa.");
			int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingresar número de teléfono"));
			String email = JOptionPane.showInputDialog("Ingresar el e-mail.");
			Cliente nuevo = new Cliente(documento, nombre, direccion, telefono, email);
			listaCliente.add(nuevo);
			JOptionPane.showConfirmDialog(null, "¡Cuenta generada correctamente! \n¡Bienvenido, "+nombre+"!");
		}
		
		public static void interfazCliente(Cliente cliente) {
			String[] opciones0 = {"Comprar fichas", "Jugar un juego", "Retirar efectivo", "Salir"};
			int eleccion0;
			do {
				eleccion0 = JOptionPane.showOptionDialog(null, cliente.getNombreCompleto()+ "\nActualmente tiene "+ cliente.getFichasActuales()+ " fichas actualmente.\nSeleccione una operación", "Casino",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
	                    null, opciones0, opciones0[0]
	            );
	            switch (eleccion0) {
	                //case 0: comprarFichas(); break;
	                case 1: seleccionarJuego(cliente); return;
	                //case 2: retirarEfectivo(); break;
	            }
			} while (eleccion0 != 2 && eleccion0 != -1);
		
			/*public static void generarEmpleado() {
				JOptionPane.showInputDialog("Ingresa el número de DNI");
			};*/
			
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
		
		public static void seleccionarJuego(Cliente cliente) {
			String[] listaJuegos = {
				    "Adivina la carta más alta",
				    "Ruleta",
				    "Tragamonedas",
				    "Dados"
				};

				String juego = (String) JOptionPane.showInputDialog(
				        null,
				        "Seleccione un juego:",
				        "Casino",
				        JOptionPane.QUESTION_MESSAGE,
				        null,
				        listaJuegos,
				        listaJuegos[0]
				);
				
			switch (juego) {
			case "Adivina la carta más alta": juegoAdivina(cliente);break;
			case "Ruleta": juegoRuleta();break;
			case "Tragamonedas": juegoTragamonedas(); break;
			case "Dados": juegoDados(); break;
			}
		};
		
		public static void juegoAdivina(Cliente cliente) {
			
			Adivina juego = new Adivina();

			if (Funciones.puedeJugar(cliente, juego)) {
			    juego.jugar(cliente,100);
			}
			else {
			    JOptionPane.showMessageDialog(null,
			            "No posee fichas suficientes para jugar.");
			}
		}
		public static void juegoRuleta() {}
		public static void juegoTragamonedas() {}
		public static void juegoDados() {}
		
	

}
