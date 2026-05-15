package casino;

public class Monedero {
	
	private Double valorFicha;
	private Double fichaEfectivo;
	private Double efectivoFicha;
	
	public Monedero(Double valorFicha,Double fichaEfectivo,Double efectivoFicha) {
		this.valorFicha = valorFicha;
		this.fichaEfectivo = fichaEfectivo;
		this.efectivoFicha = efectivoFicha;
	}

	public Double getValorFicha() {
		return valorFicha;
	}

	public void setValorFicha(Double valorFicha) {
		this.valorFicha = valorFicha;
	}

	public Double getFichaEfectivo() {
		return fichaEfectivo;
	}

	public void setFichaEfectivo(Double fichaEfectivo) {
		this.fichaEfectivo = fichaEfectivo;
	}

	public Double getEfectivoFicha() {
		return efectivoFicha;
	}

	public void setEfectivoFicha(Double efectivoFicha) {
		this.efectivoFicha = efectivoFicha;
	}

	
}
