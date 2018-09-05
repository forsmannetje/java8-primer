package nl.forsmannetje.java8.interfaces;

import java.util.Arrays;

@FunctionalInterface
public interface DoIt {

    void doIt();

    default DoIt andAfterThatDo(DoIt theOtherThing) {
        return () -> {
            this.doIt();
            theOtherThing.doIt();
        };
    }

    static DoIt forAllTheThings(DoIt... todos) {
        return () -> Arrays.stream(todos).forEach(DoIt::doIt);
    }
}
