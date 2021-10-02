package structures;

import utils.Util;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PlayGround {

    private static final Integer STRING_LENGTH = 10;
    private static final String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static Integer enclosingStaticVar = 1;
    private Integer enclosingInstanceVar = 2;

    /**
     * Generates the fixed length of random string from the given salt characters.
     * 
     * @return randomly generated String.
     */
    public static String getSaltString() {
        Comparable
        StringBuilder randomString = new StringBuilder(STRING_LENGTH);
        Random rnd = new Random();
        while (randomString.length() < STRING_LENGTH) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            randomString.append(SALTCHARS.charAt(index));
        }
        return randomString.toString();
    }

    public void instanceMethod() {
        Runnable runnable = () -> {
            final Integer someValue = 10;
            System.out.println("localVar value: " + enclosingInstanceVar);
        };
        new Thread(runnable).start();
    }

    public static void main(String[] args) throws IOException {

        // int i;
        // List<String> lists = List.of("1", "2", "3");
        // lists.stream().forEach(item -> {
        // i = 1;
        // System.out.println(i);
        // });
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // System.out.println("Hello From the Thread" + i);
        // }
        // }).start();
    }

    public int implInnerPlayGround(InnerPlayGround innerGround) {
        return innerGround.returnLength(getSaltString());
    }

    public interface InnerPlayGround {
        public int returnLength(String input);
    }
}