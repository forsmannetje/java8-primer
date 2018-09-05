package nl.forsmannetje.java8.optionals;

import nl.forsmannetje.java8.streams.Domain;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Domain domain = new Domain(0);

        Domain result = Optional.of(domain)
                .filter(Domain::shouldBeShown)
                .orElseGet(() -> new Domain(1));

        System.out.println(result);
        System.out.println(Optional.ofNullable(Domain.instanceOrNull()).isPresent());
    }
}
