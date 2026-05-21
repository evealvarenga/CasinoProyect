package casino;

import java.util.ArrayList;


public class Seed {
	public static void cargarEmpleados(ArrayList<Empleado> listaEmpleados) {
		listaEmpleados.add(new Empleado(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaEmpleados.add(new Empleado(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaEmpleados.add(new Empleado(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaEmpleados.add(new Empleado(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));	
	}
	
	public static void cargarClientes(ArrayList<Cliente> listaClientes) {
		listaClientes.add(new Cliente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaClientes.add(new Cliente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaClientes.add(new Cliente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaClientes.add(new Cliente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaClientes.add(new Cliente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaClientes.add(new Cliente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaClientes.add(new Cliente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
	}
	
	public static void cargarGerente(ArrayList <Gerente> listaGerentes) {
		listaGerentes.add(new Gerente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
	}

}
