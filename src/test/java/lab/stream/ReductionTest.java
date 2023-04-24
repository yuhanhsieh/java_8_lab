package lab.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class ReductionTest {

    @Test
    public void count() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long streamSize = stream.count();
        Assertions.assertEquals(10, streamSize);
    }

    @Test
    public void max() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalInt max = stream.mapToInt(v -> v).max();
        Assertions.assertEquals(10, max.orElse(0));
    }

    @Test
    public void findFirstElement_startWithQ() {
        Stream<String> words = Stream.of("Hello", "Queen", "Quantum", "Titan", "Mocha");

        Optional<String> word = words.filter(s -> s.startsWith("Q")).findFirst();

        Assertions.assertEquals("Queen", word.get());
    }

    @Test
    public void findAnyElement_startWithQ() {
        Stream<String> words = Stream.of("Hello", "Queen", "Quantum", "Titan", "Mocha");
        Optional<String> word = words.filter(s -> s.startsWith("Q")).findAny();

        String result = word.orElse("");

        Assertions.assertTrue(result.startsWith("Q"));
    }
}
