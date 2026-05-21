package casino;

public class Cliente extends Persona {
    private double saldo;    
    private double efectivo; 
    
   
    public Cliente(int dni, String nombreCompleto, String domicilio, int telefono, 
                   String mail, String contrasena, double saldoInicial, double efectivoInicial) {    
        super(dni, nombreCompleto, domicilio, telefono, mail, contrasena); 
        this.saldo = saldoInicial;
        this.efectivo = efectivoInicial;
    }

   
    public Cliente(double saldoInicial) {
        super(0, "Jugador Anónimo", "anonimo@casino.com", "1234");
        this.saldo = saldoInicial;
        this.efectivo = 1000.0; 
    }

    public void comprarFichasConEfectivo(double monto) {
    	
        if (monto > 0 && this.efectivo >= monto) {
        	
            this.efectivo -= monto; 
            this.saldo += monto;    
            System.out.println("Convertiste" + monto + " en fichas de juego.");
            
        } else if (monto > this.efectivo) {
            System.out.println("Error: No tienes suficiente efectivo para comprar esa cantidad de fichas.");
        } else {
            System.out.println("Error: El monto a cambiar debe ser mayor a 0.");
        }
    }

    public void descontarApuesta(int monto) {
        if (monto <= saldo) {
            this.saldo -= monto;
        }
    }

    public void recibirPremio(int monto) {
        this.saldo += monto;
    }

  
    public boolean estaEnBancarrota() {
        return this.saldo <= 0;
    }
    
    
    // GETTERS Y SETTERS 
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public double getEfectivo() { return efectivo; }
    public void setEfectivo(double efectivo) { this.efectivo = efectivo; }
}