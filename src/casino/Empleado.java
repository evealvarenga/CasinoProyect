package casino;


public class Empleado extends Persona{
	private String rango;
	
	public Empleado(int dni, String nombreCompleto, String domicilio, int telefono, String mail, String contrasena, String rango) {
		super(dni, nombreCompleto, domicilio, telefono, mail, contrasena);
		this.rango = "EMPLEADO";
	}
	
	//GETTERS Y SETTERS
	public String getRango() {return rango;}

	public void setRango(String rango) {this.rango = rango;}
}