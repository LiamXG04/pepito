package Ejercicio1;



public class Estudiante {
    private String nombreCompleto;
    private String carnet;
    private String carrera;
    private double[] notas = new double[3];

    public Estudiante(String nombreCompleto, String carnet, String carrera, double[] notas) {
        this.nombreCompleto = nombreCompleto;
        this.carnet = carnet;
        this.carrera = carrera;
        this.notas = notas;
    }

    // Getters y Setters
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCarnet() { return carnet; }
    public void setCarnet(String carnet) { this.carnet = carnet; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public double[] getNotas() { return notas; }
    public void setNotas(double[] notas) { this.notas = notas; }

    public double calcularPromedio() {
        double suma = 0;
        for(double n : notas) suma += n;
        return suma / notas.length;
    }

    public boolean aprueba() {
        return calcularPromedio() >= 6.0;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombreCompleto +
                " | Carnet: " + carnet +
                " | Carrera: " + carrera +
                " | Promedio: " + calcularPromedio() +
                " | Estado: " + (aprueba() ? "Aprobado" : "Reprobado"));
    }
}
