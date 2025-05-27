package lab4;

public class Printer {
    // Вивід значень масиву з індексом
    public void printArray(double[] arguments, double[] values) {
        for (int i = 0; i < arguments.length; i++) {
            System.out.printf("Index: %d, x = %.5f, y = %.5f%n", i, arguments[i], values[i]);
        }
    }

    // Вивід одного елемента
    public void printElement(int index, double x, double y) {
        System.out.printf("Index: %d, x = %.5f, y = %.5f%n", index, x, y);
    }
}