package nl.forsmannetje.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamDemo {

    public static void main(String[] args) {
        forLoop();
        stream();
    }

    public static void forLoop() {
        List<Domain> result = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Domain domain = new Domain(i);
            if (domain.shouldBeShown()) {
                result.add(domain);
            }
        }

        System.out.println(result);
    }

    public static void stream() {
        List<Domain> result = IntStream.range(0, 20)
                .mapToObj(Domain::new)
                .filter(Domain::shouldBeShown)
                .parallel()
                .collect(toList());

        System.out.println(result);
    }

    public static void streamInitialization() {
        new ArrayList<>().stream();

        new HashMap<>().entrySet().stream();
        new HashMap<>().keySet().stream();
        new HashMap<>().values().stream();

        Stream.of(new Object());

        Arrays.stream(new String[] {});
    }
}
