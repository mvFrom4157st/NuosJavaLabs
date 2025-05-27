package lab4;

public class Tabulation {
    private final double a = -0.5;
    private final double b = 2.0;

    // 1. Обчислення функції
    public double calculateFunction(double x) {
        if (x <= 0.7) {
            return 1.0;
        } else if (x > 0.7 && x <= 1.4) {
            return a * x * x * Math.log(x);
        } else { // x > 1.4
            return Math.exp(a * x) * Math.cos(b * x);
        }
    }

    // 2. Генерація масиву аргументів
    public double[] generateArguments(double start, double end, double step) {
        int size = (int) Math.ceil((end - start) / step) + 1;
        double[] arguments = new double[size];
        for (int i = 0; i < size; i++) {
            arguments[i] = start + i * step;
        }
        return arguments;
    }

    // 3. Генерація масиву значень функції
    public double[] calculateValues(double[] arguments) {
        double[] values = new double[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            values[i] = calculateFunction(arguments[i]);
        }
        return values;
    }

    // 4. Пошук індексу мінімального елемента
    public int findMinIndex(double[] values) {
        int minIndex = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] < values[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // 5. Пошук індексу максимального елемента
    public int findMaxIndex(double[] values) {
        int maxIndex = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // 6. Сума елементів масиву
    public double sum(double[] values) {
        double sum = 0;
        for (double v : values) sum += v;
        return sum;
    }

    // 7. Середнє арифметичне
    public double average(double[] values) {
        return sum(values) / values.length;
    }
}