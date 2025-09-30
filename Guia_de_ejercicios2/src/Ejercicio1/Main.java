package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>(); // Lista de estudiantes

        System.out.print("¿Cuántos estudiantes desea registrar?: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // Registro de estudiantes
        for(int i=0; i<cantidad; i++) {
            System.out.println("\n--- Estudiante " + (i+1) + " ---");

            System.out.print("Nombre completo: ");
            String nombre = sc.nextLine();

            System.out.print("Carnet: ");
            String carnet = sc.nextLine();

            System.out.print("Carrera: ");
            String carrera = sc.nextLine();

            double[] notas = new double[3]; // Guardar las 3 notas
            for(int j=0; j<3; j++) {
                System.out.print("Nota " + (j+1) + ": ");
                notas[j] = sc.nextDouble();
            }
            sc.nextLine(); // limpiar buffer

            estudiantes.add(new Estudiante(nombre, carnet, carrera, notas)); // Agregar a la lista
        }

        // Mostrar información de los estudiantes
        System.out.println("\n--- Información de Estudiantes ---");
        for(Estudiante e : estudiantes) {
            e.mostrarInfo();
        }

        sc.close();
    }
}


