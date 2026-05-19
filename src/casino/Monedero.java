package casino;

import javax.swing.JOptionPane;

public class Monedero {
	
	private Double saldo;
	private Double efectivo;
	
	private Double obtenerSaldo;
	private Double saldoInicial;
	
	
	
	// Constructores
	
	public Monedero(Double efectivoInicial) {
        this.efectivo = efectivoInicial;
        this.saldo = 0.0;
    }
	
	
	
	// Getters y Setters
	
	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getEfectivo() {
		return this.efectivo;
	}

	public void setEfectivo(Double efectivo) {
		this.efectivo = efectivo;
	}

	public Double getObtenerSaldo() {
		return obtenerSaldo;
	}

	public void setObtenerSaldo(Double obtenerSaldo) {
		this.obtenerSaldo = obtenerSaldo;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	
	// Metodo para comprar Fichas
	
	public boolean comprarFichas(Double cantidad){

		if ( cantidad <= 0) {
			JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor a 0 para poder comprar","Error", JOptionPane.ERROR_MESSAGE);
			return false;
			
		} if (this.efectivo >= cantidad) {
			this.efectivo -= cantidad;
			this.saldo += cantidad;
			JOptionPane.showMessageDialog(null,"Compra realizada,\n Cambiaste $" + cantidad + "en fichas", "Cajero Casino", JOptionPane.INFORMATION_MESSAGE);
		return true;
		
		} else {
            JOptionPane.showMessageDialog(null, "No tienes suficiente efectivo.\nEfectivo disponible: $" + this.efectivo, "Fondos Insuficientes", JOptionPane.WARNING_MESSAGE);
            return false;
        }
	}
	

	// Método para retirar fichas de la mesa y volverlas a convertir en efectivo //
	
    public void canjearFichas(Double cantidad) {
    	if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            this.efectivo += cantidad;
            JOptionPane.showMessageDialog(null, "¡Canje exitoso!\nHas retirado " + cantidad + " fichas a tu efectivo.", "Cajero Casino", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes tantas fichas para canjear.\nFichas disponibles: " + this.saldo, "Error de Canje", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método directo para cuando el jugador gana un premio en los juegos //
    
    public void sumarFichas(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
        }
    }

    // Método directo para validar y restar la apuesta en la mesa de juego //
    
    public boolean restarFichas(double cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            return true; 
        } else {
            return false; 
        }
    }
}
