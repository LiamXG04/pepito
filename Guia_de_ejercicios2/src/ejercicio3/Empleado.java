package ejercicio3;



public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }

    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Puesto: " + puesto + " | Salario: $" + salario;
    }
}

