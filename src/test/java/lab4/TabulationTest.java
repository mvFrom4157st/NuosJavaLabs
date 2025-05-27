package lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TabulationTest {

    @Test
    void testCalculateFunctionForXLessThanOrEqual07() {
        Tabulation tab = new Tabulation();
        assertEquals(1.0, tab.calculateFunction(0.5), 1e-6);
        assertEquals(1.0, tab.calculateFunction(0.7), 1e-6);
    }

    @Test
    void testCalculateFunctionFor07To14() {
        Tabulation tab = new Tabulation();
        double x = 1.0;
        double expected = -0.5 * x * x * Math.log(x);
        assertEquals(expected, tab.calculateFunction(x), 1e-6);
    }

    @Test
    void testCalculateFunctionForXGreaterThan14() {
        Tabulation tab = new Tabulation();
        double x = 2.0;
        double expected = Math.exp(-0.5 * x) * Math.cos(2.0 * x);
        assertEquals(expected, tab.calculateFunction(x), 1e-6);
    }

    @Test
    void testGenerateArguments() {
        Tabulation tab = new Tabulation();
        double[] args = tab.generateArguments(0.0, 0.008, 0.004);
        assertArrayEquals(new double[]{0.0, 0.004, 0.008}, args, 1e-9);
    }

    @Test
    void testCalculateValues() {
        Tabulation tab = new Tabulation();
        double[] args = {0.5, 1.0, 2.0};
        double[] expected = {
            1.0, // x = 0.5 (x <= 0.7)
            -0.5 * 1.0 * 1.0 * Math.log(1.0), // x = 1.0 (0.7 < x <= 1.4)
            Math.exp(-0.5 * 2.0) * Math.cos(2.0 * 2.0) // x = 2.0 (x > 1.4)
        };
        double[] actual = tab.calculateValues(args);
        assertArrayEquals(expected, actual, 1e-9);
    }

    @Test
    void testFindMinIndex() {
        Tabulation tab = new Tabulation();
        double[] values = {5.0, 2.0, 3.0, 1.0, 4.0};
        assertEquals(3, tab.findMinIndex(values));
    }

    @Test
    void testFindMaxIndex() {
        Tabulation tab = new Tabulation();
        double[] values = {5.0, 2.0, 7.0, 1.0, 4.0};
        assertEquals(2, tab.findMaxIndex(values));
    }

    @Test
    void testSum() {
        Tabulation tab = new Tabulation();
        double[] values = {1.0, 2.0, 3.0};
        assertEquals(6.0, tab.sum(values), 1e-9);
    }

    @Test
    void testAverage() {
        Tabulation tab = new Tabulation();
        double[] values = {2.0, 4.0, 6.0};
        assertEquals(4.0, tab.average(values), 1e-9);
    }
    
}