package com.nuos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // (Варіант 1 -> a=0.7, b=0.05, c=0.5)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of а: ");
        Double a = scanner.nextDouble();
        System.out.print("Enter value of b: ");
        Double b = scanner.nextDouble();
        System.out.print("Enter value of c: ");
        Double c = scanner.nextDouble();

        // Calculator для обчислення
        Calculator calculator = new Calculator();
        double result1 = calculator.calculateFormula1(a, b, c);
        double result2 = calculator.calculateFormula2(a, b, c);

        // Printer для результатів
        Printer printer = new Printer();
        printer.printDouble("a", a);
        printer.printDouble("b", b);
        printer.printDouble("c", c);
        printer.printDouble("Result #1", result1);
        printer.printDouble("Result #2", result2);

        // Дата
        printer.printDate("yy-MM-dd");
    }
}
