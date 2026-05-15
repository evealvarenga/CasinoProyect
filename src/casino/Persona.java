package casino;

public class Persona {
	private int dni;
	private String nombreCompleto;
	private String domicilio;
	private int telefono;
	private String mail;
	private String contrasena;
	
	public Persona(int dni, String nombreCompleto, String domicilio, int telefono, String mail, String contrasena) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.contrasena = contrasena;
	}
	
	public Persona(int dni, String nombreCompleto, String mail, String contrasena) {
		this.dni = dni;
		this.nombreCompleto= nombreCompleto;
		this.domicilio = null;
		this.telefono = 0;
		this.mail = mail;
		this.contrasena = contrasena;
	}
	
	//GETTERS Y SETTERS
	public int getDni() {return dni;}
	public String getNombreCompleto() {return nombreCompleto;}
	public String getDomicilio() {return domicilio;}
	public int getTelefono() {return telefono;}
	public String getMail() {return mail;}
	public String getContrasena() {return contrasena;}

	public void setDni(int dni) {this.dni = dni;}
	public void setNombreCompleto(String nombreCompleto) {this.nombreCompleto = nombreCompleto;}
	public void setDomicilio(String domicilio) {this.domicilio = domicilio;}
	public void setTelefono(int telefono) {this.telefono = telefono;}
	public void setMail(String mail) {this.mail = mail;}
	public void setContrasena(String contrasena) {this.contrasena = contrasena;}
	
	//FUNCIONES
	
	

}
