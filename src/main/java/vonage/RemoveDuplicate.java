package vonage;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.function.IntFunction;

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
        IntFunction<String> intFunction = c -> String.valueOf((char) c);
        return input.chars().distinct().mapToObj(intFunction).collect(Collectors.joining());
        // Can't use the below method reference as we have to explicitly cast the
        // integer to char
        // return
        // input.chars().distinct().mapToObj(String::valueof(c)).collect(Collectors.joining());
    }

    /**
     * <p>
     * You are given a String S, in which one letter occurs twice. Every other letter occurs at most once.
     * Write a function, which, given a string S, returns a single-character string: the letter that occurs twice.
     * <li>Example:</li>
     * <li> Given S="aba", the function should return "a".</li>
     * <li> Given S="zz", the function should return "z".</li>
     * <li> Given S="codility", the function should return "i".</li>
     * Assume that:
     * <ul> All letters in S are distinct except one, which occurs twice </ul>
     * </p>
     * @param args
     */
    public static String findFirstDupChar(String input) {
        if (StringUtils.isBlank(input))
            return StringUtils.EMPTY;
        Set<Integer> allChars = new HashSet<>();
        return input.codePoints().filter(character -> !allChars.add(character)).limit(1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    /**
     * Return the first duplicate character from the given string. Typical Java way.
     * 
     * @param input - input
     */
    public static String findFirstDuplicateChar(String input) {
        if (StringUtils.isBlank(input))
            return StringUtils.EMPTY;
        Set<String> set = new HashSet<>();
        for (String ch : input.split(StringUtils.EMPTY)) {
            if (!set.add(ch)) {
                return ch;
            }
            set.add(ch);
        }
        set = null;
        return StringUtils.EMPTY;
    }
}