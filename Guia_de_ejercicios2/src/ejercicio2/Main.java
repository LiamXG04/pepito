package ejercicio2;





import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Rectángulo:");
        System.out.print("Base: ");
        double base = sc.nextDouble();
        System.out.print("Altura: ");
        double altura = sc.nextDouble();
        Rectangulo rect = new Rectangulo(base, altura);

        System.out.println("\nCuadrado:");
        System.out.print("Lado: ");
        double lado = sc.nextDouble();
        Rectangulo cuadrado = new Rectangulo(lado);

        System.out.println("\nResultados:");
        System.out.println("Rectángulo - Área: " + rect.calcularArea() + ", Perímetro: " + rect.calcularPerimetro());
        System.out.println("Cuadrado - Área: " + cuadrado.calcularArea() + ", Perímetro: " + cuadrado.calcularPerimetro());

        sc.close();
    }
}


