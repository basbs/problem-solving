package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class Util {

    public static List<String> readFileToList(String absolutePath, String fileName) throws IOException {
        if (StringUtils.isBlank(fileName))
            return Collections.emptyList();
        final List<String> lines = Files.readAllLines(Paths.get(absolutePath, fileName));
        return lines;
    }

    public static List<String> readFileAsList(String fileName) throws IOException {
        if (StringUtils.isBlank(fileName))
            return Collections.emptyList();
        final List<String> lines = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            for (;;) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                lines.add(line);
            }
            return lines;
        }
    }
}
