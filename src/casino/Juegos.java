package casino;

public class Juegos {
    private double apuestaMinima;

    public Juegos(double apuestaMinima) {
        this.apuestaMinima = apuestaMinima;
    }
    
    //Getters y setters
	public double getApuestaMinima() {return apuestaMinima;}
	public void setApuestaMinima(double apuestaMinima) {this.apuestaMinima = apuestaMinima;}
	
	//Funciones generales de juegos
	public static int valorRandom(int valor) {
		int numeroRandom = (int) (Math.random() * valor) + 1;
		return numeroRandom;
	}
	

}