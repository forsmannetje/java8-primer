package nl.forsmannetje.java8.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingLines {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        ReadingLines.class.getResourceAsStream("/sample.txt")
                )
        )) {
            reader.lines().forEach(System.out::println);
        }
    }
}
