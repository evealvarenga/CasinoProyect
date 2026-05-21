package casino;

import java.util.ArrayList;

public class Main {
	static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	static ArrayList<Cliente> listaCliente = new ArrayList<>();
	static ArrayList<Gerente> listaGerente = new ArrayList<>();

	public static void main(String[] args) {	
		Seed.cargarEmpleados(listaEmpleados);
		Seed.cargarClientes(listaCliente);
		Seed.cargarGerente(listaGerente);
		
		//Inicio del programa
		
		
	}

}
