package vonage;

import org.junit.jupiter.api.Test;

import utils.Util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;

public class RemoveDuplicateTest {

    @Test
    public void testRemoveDuplicateCharsWhenStringIsEmpty() {
        assertEquals(StringUtils.EMPTY, RemoveDuplicate.removeDuplicateChars(StringUtils.EMPTY));
    }

    @Test
    public void testRemoveDuplicateCharsWhenStringIsBlank() {
        assertEquals(StringUtils.EMPTY, RemoveDuplicate.removeDuplicateChars("    "));
    }

    @Test
    public void testRemoveDuplicateCharsWhenStringIsNull() {
        assertEquals(StringUtils.EMPTY, RemoveDuplicate.removeDuplicateChars(null));
    }

    @Test
    public void testRemoveDuplicateCharsWhenStringIsNotDuplicate() {
        String input = "quirky";
        assertEquals(input, RemoveDuplicate.removeDuplicateChars(input));
    }

    @Test
    public void testRemoveDuplicateCharsWhenStringIsIsDuplicate() {
        assertEquals("quirky-tng", RemoveDuplicate.removeDuplicateChars("quirky-turing"));
    }

    @Test
    public void testfindFirstDupCharWhenStringIsNotDuplicate() throws IOException, URISyntaxException {
        List<String> input = Util.readFileAsList("findFirstDupCharInput.txt");
        List<String> output = Util.readFileAsList("findFirstDupCharOutput.txt");
        if (input.size() == output.size())
            for (int i = 0; i < input.size(); i++)
                assertEquals(output.get(i), RemoveDuplicate.findFirstDupChar(input.get(i)));
    }

}
