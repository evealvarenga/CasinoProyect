package casino;

import javax.swing.JOptionPane;

public class Monedero {
	
	private Double valorFicha;
	private double saldototal;
	
	
	public Monedero(Double valorFicha, double saldo) {
		this.valorFicha = valorFicha;
		this.saldototal = saldo;
	}
	
	//SETTERS Y GETTERS
	public Double getValorFicha() {return valorFicha;}
	public void setValorFicha(Double valorFicha) {this.valorFicha = valorFicha;}
	public double getSaldototal() {return saldototal;}
	public void setSaldototal(double saldototal) {this.saldototal = saldototal;}
	
	// FUNCIONES
	
	public void mostrarSaldoTotal() {
		JOptionPane.showMessageDialog(null, "El saldo total actual es de: $" + saldototal );
	}
	
	public double compraFichas(double importe) {
	    int fichasCompradas = (int) Math.round(importe / valorFicha);
	    saldototal += importe;
	    return fichasCompradas;
	}
	
	public double retiroEfectivo(double fichas) {
	    double efectivo = fichas * valorFicha;
	    if (efectivo > saldototal) {
	        throw new IllegalArgumentException(
	            "El casino no posee saldo suficiente."
	        );
	    }
	    saldototal -= efectivo;
	    return efectivo;
	}
	
	
	
}