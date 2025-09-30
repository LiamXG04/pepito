package ejercicio5;





import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pelicula> peliculas = new ArrayList<>(); // Lista de películas
        ArrayList<Sala> salas = new ArrayList<>();         // Lista de salas
        ArrayList<Reserva> reservas = new ArrayList<>();   // Lista de reservas

        int opcion;
        // Menú principal del sistema de cine
        do {
            System.out.println("\n--- Menú Sistema de Cine ---");
            System.out.println("1. Agregar película");
            System.out.println("2. Agregar sala");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Cancelar reserva");
            System.out.println("5. Mostrar reservas");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch(opcion) {
                case 1: // Agregar película
                    System.out.print("Código película: ");
                    String cod = sc.nextLine();
                    System.out.print("Título: ");
                    String tit = sc.nextLine();
                    System.out.print("Género: ");
                    String gen = sc.nextLine();
                    System.out.print("Duración (min): ");
                    int dur = sc.nextInt();
                    sc.nextLine();
                    peliculas.add(new Pelicula(cod, tit, gen, dur));
                    break;

                case 2: // Agregar sala
                    System.out.print("Número de sala: ");
                    int num = sc.nextInt();
                    System.out.print("Capacidad total: ");
                    int cap = sc.nextInt();
                    sc.nextLine();
                    salas.add(new Sala(num, cap));
                    break;

                case 3: // Realizar reserva
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();

                    System.out.print("Código de película: ");
                    String codP = sc.nextLine();
                    Pelicula peli = peliculas.stream().filter(p -> p.getCodigo().equals(codP)).findFirst().orElse(null);
                    if(peli == null) {
                        System.out.println("Película no encontrada.");
                        break;
                    }

                    System.out.print("Número de sala: ");
                    int numSala = sc.nextInt();
                    sc.nextLine();
                    Sala sala = salas.stream().filter(s -> s.getNumero() == numSala).findFirst().orElse(null);
                    if(sala == null) {
                        System.out.println("Sala no encontrada.");
                        break;
                    }

                    System.out.print("Cantidad de asientos: ");
                    int asientos = sc.nextInt();
                    sc.nextLine();
                    if(sala.reservar(asientos)) { // Verifica si hay capacidad
                        reservas.add(new Reserva(cliente, peli, sala, asientos));
                        System.out.println("¡Reserva realizada correctamente!");
                    } else {
                        System.out.println("No hay capacidad suficiente en la sala.");
                    }
                    break;

                case 4: // Cancelar reserva
                    if(reservas.isEmpty()) {
                        System.out.println("No hay reservas para cancelar.");
                        break;
                    }
                    System.out.println("\nLista de reservas:");
                    for(int i = 0; i < reservas.size(); i++) {
                        System.out.println((i+1) + ". " + reservas.get(i));
                    }
                    System.out.print("Seleccione número de reserva a cancelar: ");
                    int numRes = sc.nextInt();
                    sc.nextLine();
                    if(numRes >= 1 && numRes <= reservas.size()) {
                        Reserva r = reservas.remove(numRes-1);
                        r.getSala().cancelar(r.getAsientos()); // Libera los asientos en la sala
                        System.out.println("Reserva cancelada: " + r);
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;

                case 5: // Mostrar reservas
                    if(reservas.isEmpty()) {
                        System.out.println("No hay reservas realizadas.");
                    } else {
                        System.out.println("\n--- Reservas ---");
                        for(Reserva r : reservas) System.out.println(r);
                    }
                    break;
            }
        } while(opcion != 6); // Repetir hasta salir

        sc.close(); // Cerrar Scanner
    }
}


