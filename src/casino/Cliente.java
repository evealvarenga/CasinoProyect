package casino;

public class Cliente extends Persona{
	private String rango;
	private double fichasActuales;
	
	public Cliente(int dni, String nombreCompleto, String domicilio, int telefono, String mail, String contrasena, String rango) {
		super(dni, nombreCompleto, domicilio, telefono, mail, contrasena);
		this.rango = "CLIENTE";
		this.fichasActuales = 0;
	}
	
	//GETTERS Y SETTERS
	public String getRango() {return rango;}
	public double getFichasActuales(){return fichasActuales;}

	public void setRango(String rango) {this.rango = rango;}
	public void setfichasActuales(double fichasActuales) {this.fichasActuales = fichasActuales;}
}
