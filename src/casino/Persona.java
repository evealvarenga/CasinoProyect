package casino;

public class Persona {
	private int dni;
	private String nombreCompleto;
	private String domicilio;
	private int telefono;
	private String mail;
	private String rango;
	
	public Persona(int dni, String nombreCompleto, String domicilio, int telefono, String mail, String rango) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.rango = rango; 
	}
	
	public Persona(int dni, String nombreCompleto, String mail) {
		this.dni = dni;
		this.nombreCompleto= nombreCompleto;
		this.domicilio = null;
		this.telefono = 0;
		this.mail = mail;
	}
	
	//GETTERS Y SETTERS
	public int getDni() {return dni;}
	public String getNombreCompleto() {return nombreCompleto;}
	public String getDomicilio() {return domicilio;}
	public int getTelefono() {return telefono;}
	public String getMail() {return mail;}
	public String getRango() {return rango;}

	public void setDni(int dni) {this.dni = dni;}
	public void setNombreCompleto(String nombreCompleto) {this.nombreCompleto = nombreCompleto;}
	public void setDomicilio(String domicilio) {this.domicilio = domicilio;}
	public void setTelefono(int telefono) {this.telefono = telefono;}
	public void setMail(String mail) {this.mail = mail;}
	public void setRango(String rango) {this.rango = rango;}
	
	//FUNCIONES
	
	

}
