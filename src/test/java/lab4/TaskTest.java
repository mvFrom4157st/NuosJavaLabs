package lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testReplaceKthLetterInWords() {
        Task task = new Task();
        String input = "hello world my friend";
        String expected = "heXlo woXld my frXend";
        // k = 3, ch = 'X'
        String actual = task.replaceKthLetterInWords(input, 3, 'X');
        assertEquals(expected, actual);
    }

    @Test
    void testReplaceKthLetterInWordsUniversal() {
        Task task = new Task();
        String input = "hello, world!";
        String expected = "heXlo, woXld!";
        // k = 3, ch = 'X'
        String actual = task.replaceKthLetterInWordsUniversal(input, 3, 'X');
        assertEquals(expected, actual);
    }

}