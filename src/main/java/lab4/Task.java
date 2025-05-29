package lab4;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task {
    
    // Слова розділені лише пропусками
    public String replaceKthLetterInWords(String text, int k, char ch) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() >= k) {
                result.append(word, 0, k - 1)
                      .append(ch)
                      .append(word.substring(k));
            } else {
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    // Слова розділені будь-якими символами
    public String replaceKthLetterInWordsUniversal(String text, int k, char ch) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\\p{L}+");
        Matcher matcher = pattern.matcher(text);
        int lastEnd = 0;
        while (matcher.find()) {
            // Роздільник
            result.append(text, lastEnd, matcher.start());
            String word = matcher.group();
            if (word.length() >= k) {
                result.append(word.substring(0, k - 1))
                    .append(ch)
                    .append(word.substring(k));
            } else {
                result.append(word);
            }
            lastEnd = matcher.end();
        }

        result.append(text.substring(lastEnd));
        return result.toString();
    }
}
