package ejercicio5;



public class Sala {
    private int numero;               // Número identificador de la sala
    private int capacidadTotal;        // Capacidad total de la sala
    private int capacidadDisponible;   // Capacidad disponible actualmente

    // inicializa número y capacidad, disponible igual a total
    public Sala(int numero, int capacidadTotal) {
        this.numero = numero;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
    }

    public int getNumero() { return numero; }       // Obtener número de sala
    public int getCapacidadDisponible() { return capacidadDisponible; } // Obtener asientos disponibles

    // Reservar asientos: verifica si hay suficiente capacidad
    public boolean reservar(int cantidad) {
        if(cantidad <= capacidadDisponible) {
            capacidadDisponible -= cantidad;
            return true; // Reserva exitosa
        }
        return false; // No hay capacidad suficiente
    }

    // Cancelar reserva: devuelve los asientos cancelados a la disponibilidad
    public void cancelar(int cantidad) {
        capacidadDisponible += cantidad;
    }

    @Override
    public String toString() {
        return "Sala " + numero + " | Capacidad: " + capacidadDisponible + "/" + capacidadTotal;
    }
}

