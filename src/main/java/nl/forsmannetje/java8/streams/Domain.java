package nl.forsmannetje.java8.streams;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Domain {
    private static final Random RANDOM;

    static {
        try {
            RANDOM = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException nsae) {
            throw new ExceptionInInitializerError(nsae);
        }
    }

    private final int instance;

    public static Domain instanceOrNull() {
        return RANDOM.nextBoolean() ? new Domain(RANDOM.nextInt()) : null;
    }

    public Domain(int instance) {
        this.instance = instance;
    }

    public boolean shouldBeShown() {
        return RANDOM.nextBoolean();
    }

    public String toString() {
        return "Domain instance [" + instance + "]";
    }
}
