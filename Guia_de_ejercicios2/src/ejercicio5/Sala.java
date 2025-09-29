package ejercicio5;



public class Sala {
    private int numero;
    private int capacidadTotal;
    private int capacidadDisponible;

    public Sala(int numero, int capacidadTotal) {
        this.numero = numero;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
    }

    public int getNumero() { return numero; }
    public int getCapacidadDisponible() { return capacidadDisponible; }

    public boolean reservar(int cantidad) {
        if(cantidad <= capacidadDisponible) {
            capacidadDisponible -= cantidad;
            return true;
        }
        return false;
    }

    public void cancelar(int cantidad) {
        capacidadDisponible += cantidad;
    }

    @Override
    public String toString() {
        return "Sala " + numero + " | Capacidad: " + capacidadDisponible + "/" + capacidadTotal;
    }
}
