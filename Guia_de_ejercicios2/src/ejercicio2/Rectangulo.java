package ejercicio2;



public class Rectangulo {
    private double base;
    private double altura;

    // Constructor rectángulo
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Constructor cuadrado
    public Rectangulo(double lado) {
        this.base = lado;
        this.altura = lado;
    }

    public double calcularArea() { return base * altura; }
    public double calcularPerimetro() { return 2 * (base + altura); }
}
