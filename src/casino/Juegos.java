package casino;

public class Juegos {
    private final Ruleta ruleta;
    private final Cliente jugador;


    public Juegos() {
        this.ruleta = new Ruleta();
        this.jugador = new Cliente(1000); // El jugador arranca con $1000
    }

    // Métodos para que la clase del Main pueda interactuar con ellos
    
    public Ruleta getRuleta() {
        return ruleta;
    }

    public Cliente getJugador() {
        return jugador;
    }
}
