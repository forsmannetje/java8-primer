package nl.forsmannetje.java8.lambda;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LambdaDemoFinished {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        List<Integer> randomNumbers = SecureRandom.getInstanceStrong()
                .ints(10, 0, 500)
                .boxed()
                .collect(toList());


        LambdaDemoFinished.sortingOld(randomNumbers);
        LambdaDemoFinished.sortingNew(randomNumbers);
    }

    private static void sortingOld(List<Integer> randomNumbers) {
        Collections.shuffle(randomNumbers);
        Collections.sort(randomNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // reverse sort
            }
        });

        System.out.println(randomNumbers);
    }

    private static void sortingNew(List<Integer> randomNumbers) {
        Collections.shuffle(randomNumbers);
        Collections.sort(randomNumbers, (o1, o2) -> o2 - o1);

        System.out.println(randomNumbers);
    }

    public static void effectivelyFinal() {
        int i = 42;

        // Does not compile ...
        Runnable runnable = () -> System.out.println(i);
        runnable.run();

        // ... because of this
        i = 10;
    }
}
