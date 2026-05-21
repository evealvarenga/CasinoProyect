package casino;

public class NumeroRuleta {
	
	private final int valor;
    private final String color;

    
    public NumeroRuleta(int valor, String color) {
        this.valor = valor;
        this.color = color;
    }

    
    public int getValor() {
        return valor;
    }

    public String getColor() {
        return color;
    }
}

