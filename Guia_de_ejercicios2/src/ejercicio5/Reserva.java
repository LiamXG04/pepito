package ejercicio5;



public class Reserva {
    private String cliente;
    private Pelicula pelicula;
    private Sala sala;
    private int asientos;

    public Reserva(String cliente, Pelicula pelicula, Sala sala, int asientos) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.sala = sala;
        this.asientos = asientos;
    }

    public int getAsientos() { return asientos; }
    public Sala getSala() { return sala; }

    @Override
    public String toString() {
        return "Cliente: " + cliente + " | Película: " + pelicula + " | Sala: " + sala.getNumero() + " | Asientos: " + asientos;
    }
}

