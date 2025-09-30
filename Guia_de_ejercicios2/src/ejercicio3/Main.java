package ejercicio3;





import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>(); // Lista de empleados
        int opcion;

        // Menú principal
        do {
            System.out.println("\n--- Menú Empleados ---");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Buscar empleado por ID");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch(opcion) {
                case 1: // Agregar empleado
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    boolean existe = empleados.stream().anyMatch(e -> e.getId() == id);
                    if(existe) {
                        System.out.println("¡ID ya existe!");
                        break;
                    }
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Puesto: ");
                    String puesto = sc.nextLine();
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();
                    empleados.add(new Empleado(id, nombre, puesto, salario));
                    break;

                case 2: // Listar empleados
                    System.out.println("\n--- Lista de Empleados ---");
                    for(Empleado e : empleados) System.out.println(e);
                    break;

                case 3: // Buscar empleado por ID
                    System.out.print("Ingrese ID a buscar: ");
                    int buscarId = sc.nextInt();
                    sc.nextLine();
                    Empleado encontrado = empleados.stream()
                            .filter(e -> e.getId() == buscarId)
                            .findFirst()
                            .orElse(null);
                    System.out.println(encontrado != null ? encontrado : "Empleado no encontrado");
                    break;

                case 4: // Eliminar empleado
                    System.out.print("Ingrese ID a eliminar: ");
                    int eliminarId = sc.nextInt();
                    sc.nextLine();
                    empleados.removeIf(e -> e.getId() == eliminarId);
                    System.out.println("Empleado eliminado (si existía).");
                    break;
            }
        } while(opcion != 5); // Repite hasta que el usuario elija salir

        sc.close(); // Cerrar scanner
    }
}



