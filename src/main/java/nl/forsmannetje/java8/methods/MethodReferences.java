package nl.forsmannetje.java8.methods;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {

    private int theThing = 42;

    private int getTheThing() {
        return theThing;
    }

    private static int doSomething(int subtract) {
        return new MethodReferences().getTheThing() - subtract;
    }

    public static void main(String[] args) {
        constructorReference();
        instanceMethodReference();
        classMethodReference();
        staticMethodReference();
    }

    public static void constructorReference() {
        Supplier<MethodReferences> methodReference = MethodReferences::new;

        System.out.println("Constructor method reference: " + methodReference.get());
    }

    private static void instanceMethodReference() {
        MethodReferences stuff = new MethodReferences();

        Supplier<Integer> methodReference = stuff::getTheThing;

        System.out.println("Class method reference: " +  methodReference.get());
    }

    private static void classMethodReference() {
        Function<MethodReferences, Integer> methodReference = MethodReferences::getTheThing;

        System.out.println("Class method reference: " +  methodReference.apply(new MethodReferences()));
    }

    private static void staticMethodReference() {
        Function<Integer, Integer> methodReference = MethodReferences::doSomething;

        System.out.println("Static method reference: " + methodReference.apply(12));
    }
}
