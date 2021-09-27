package vonage;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class RemoveDuplicate {

    /**
     * Remove duplicate character from the given string.
     */
    public static String removeDuplicateChars(String input) {
        // Without StringUtils library
        // if(input == null || input.isEmpty() || input.trim().isEmpty())
        if (StringUtils.isBlank(input))
            return StringUtils.EMPTY;
        return input.chars().distinct().mapToObj(String::valueOf).collect(Collectors.joining());
    }

    /**
     * Return the first duplicate character from the given string.
     * 
     * @param args
     */
    public static String findFirstDupChar(String input) {
        if (StringUtils.isBlank(input))
            return StringUtils.EMPTY;
        Set<Integer> allChars = new HashSet<>();
        return input.codePoints().filter(character -> !allChars.add(character)).limit(1).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static void main(String[] args) {
        String oneString = "aba";
        // IntFunction<String> intFunction = intChar -> String.valueOf((char) intChar);
        // System.out.println(oneString.chars().distinct().mapToObj(intFunction).collect(Collectors.joining()));
        System.out.println(findFirstDupChar(oneString));
    }
}