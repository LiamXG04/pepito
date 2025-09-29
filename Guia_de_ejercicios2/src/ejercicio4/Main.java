package ejercicio4;





import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        System.out.print("¿Cuántos autos desea ingresar?: ");
        int cantidadAutos = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < cantidadAutos; i++) {
            System.out.println("\n--- Auto " + (i+1) + " ---");
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("Año: ");
            int año = sc.nextInt();
            System.out.print("Número de puertas: ");
            int puertas = sc.nextInt();
            sc.nextLine();
            vehiculos.add(new Auto(marca, modelo, año, puertas));
        }

        System.out.print("\n¿Cuántas motos desea ingresar?: ");
        int cantidadMotos = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < cantidadMotos; i++) {
            System.out.println("\n--- Moto " + (i+1) + " ---");
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("Año: ");
            int año = sc.nextInt();
            System.out.print("Cilindraje: ");
            int cilindraje = sc.nextInt();
            sc.nextLine();
            vehiculos.add(new Moto(marca, modelo, año, cilindraje));
        }

        System.out.println("\n--- Información de Vehículos ---");
        for(Vehiculo v : vehiculos) {
            v.mostrarInfo();
            System.out.println("-------------------");
        }

        sc.close();
    }
}


