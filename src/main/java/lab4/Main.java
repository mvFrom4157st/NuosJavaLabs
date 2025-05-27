package lab4;

public class Main {
    public static void main(String[] args) {
        Tabulation tabulation = new Tabulation();
        Printer printer = new Printer();

        // Параметри
        double start = 0.0;
        double end = 3.0;
        double step = 0.004;

        // Генерація даних
        double[] arguments = tabulation.generateArguments(start, end, step);
        double[] values = tabulation.calculateValues(arguments);

        // Вивід усіх значень
        printer.printArray(arguments, values);

        // Пошук індексів мінімального та максимального значення
        int minIndex = tabulation.findMinIndex(values);
        int maxIndex = tabulation.findMaxIndex(values);

        // Сума та середнє
        double sum = tabulation.sum(values);
        double average = tabulation.average(values);

        // Вивід результатів
        System.out.println("Results:");
        System.out.println("> Number of tabulation points: " + arguments.length);
        System.out.printf("> Minimum value: %.5f\n\t(x = %.5f, index: %d)%n", values[minIndex], arguments[minIndex], minIndex);
        System.out.printf("> Maximum value: %.5f\n\t(x = %.5f, index: %d)%n", values[maxIndex], arguments[maxIndex], maxIndex);
        System.out.printf("> Sum of function value array elements: %.5f%n", sum);
        System.out.printf("> Average value: %.5f%n", average);

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