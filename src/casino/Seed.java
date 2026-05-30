package casino;

import java.util.ArrayList;


public class Seed {
	public static void cargarEmpleados(ArrayList<Empleado> listaEmpleados) {
		listaEmpleados.add(new Empleado(11111111, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaEmpleados.add(new Empleado(22222222, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaEmpleados.add(new Empleado(33333333, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
		listaEmpleados.add(new Empleado(44444444, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));	
	}
	
	public static void cargarClientes(ArrayList<Cliente> listaClientes) {
		listaClientes.add(new Cliente(55555555, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com",123765.74));
		listaClientes.add(new Cliente(66666666, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com",243327387.44));
		listaClientes.add(new Cliente(77777777, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com",776315.24));
		listaClientes.add(new Cliente(88888888, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com",762534.34));
		listaClientes.add(new Cliente(99999999, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com",48756.14));
		listaClientes.add(new Cliente(12345678, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com",123.14));
		listaClientes.add(new Cliente(234567891, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com",4837.64));
	}
	
	public static void cargarGerente(ArrayList <Gerente> listaGerentes) {
		listaGerentes.add(new Gerente(345678912, "Juan Pérez", "Calle Falsa 123", 11223344, "juan@gmail.com"));
	}
	
	public static Monedero cargarBanca() {
	    return new Monedero(100.20, 127361872386.20);
	}

}
