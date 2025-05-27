package lab4;

public class Main {
    public static void main(String[] args) {
        Tabulation tabulation = new Tabulation();
        Printer printer = new Printer();

        // Параметри
        double start = 0.0;
        double end = 3.0;
        double stepX = 0.004;

        // Генерація аргументів та значень
        double[] arguments = tabulation.generateArguments(start, end, stepX);
        double[] values = tabulation.calculateValues(arguments);

        // Вивід усіх значень
        printer.printArray(arguments, values);

        // Пошук індексів мінімального та максимального значення
        int minIndex = tabulation.findMinIndex(values);
        int maxIndex = tabulation.findMaxIndex(values);

        // Сума та середнє
        double sum = tabulation.sum(values);
        double average = tabulation.average(values);

        System.out.println("Results:");
        System.out.println("> Number of tabulation points: " + arguments.length);
        System.out.printf("> Minimum X value: %.4f\n  (X = %.4f , Index: %d)%n", values[minIndex], arguments[minIndex], minIndex);
        System.out.printf("> Maximum X value: %.4f\n  (X = %.4f , Index: %d)%n", values[maxIndex], arguments[maxIndex], maxIndex);
        System.out.printf("> Sum of function value array elements: %.4f%n", sum);
        System.out.printf("> Average value: %.4f%n", average);

        // Вивід значень для тестових індексів
        int[] testIndixes = {175, 350, 750};
        System.out.println("> Test values:");
        for (int idx : testIndixes) {
            if (idx >= 0 && idx < arguments.length) {
                printer.printElement(idx, arguments[idx], values[idx]);
            }
        }
    }
}
