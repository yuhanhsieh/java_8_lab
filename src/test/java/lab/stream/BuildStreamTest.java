package lab.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

public class BuildStreamTest {

    @Test
    public void makeStreamOfArray() {
        String[] bookArray = {"A little presences", "Lord of Ring", "Harry Potter"};
        Stream<String> stream = Stream.of(bookArray);

        long count = stream.filter(book -> book.length() > 15).count();

        Assertions.assertEquals(1, count);
    }

    @Test
    public void makeNoElementStream() {
        Stream<Object> empty = Stream.empty();

        Optional<Object> any = empty.findAny();

        Assertions.assertEquals(Optional.empty(), any);
    }

    @Test
    public void makeUnlimitedElementStream() {
        Stream<String> echos = Stream.generate(() -> "echo");

        Optional<String> any = echos.findAny();

        Assertions.assertEquals("echo", any.orElse(""));
    }

    @Test
    public void makeUnlimitedRandomDigitElementStream() {
        Stream<Double> randoms = Stream.generate(Math::random);

        Optional<Double> any = randoms.findAny();

        Assertions.assertTrue(any.isPresent());
    }

    @Test
    public void makeUnlimitedDigitElementStream() {
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO,  n -> n.add(BigInteger.ONE));

        Optional<BigInteger> any = integers.findAny();

        Assertions.assertTrue(any.isPresent());
    }
}
