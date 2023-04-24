package lab.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtractAndConcatStreamTest {

    @Test
    public void limitStream() {
        int size = 500;
        Stream<Double> randoms = Stream.generate(Math::random).limit(size);

        List<Double> digitWords = randoms.collect(Collectors.toList());

        Assertions.assertEquals(size, digitWords.size());
    }

    @Test
    public void splitStream() {
        List<Integer> result = Stream.of(11, 25, 36, 74, 5, 69, 77, 89, 98, 210).skip(2).collect(Collectors.toList());

        Assertions.assertEquals(36, result.get(0));
    }

    @Test
    public void concatStream() {
        Stream<Integer> stream_1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream_2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> merged = Stream.concat(stream_1, stream_2);
        List<Integer> result = merged.collect(Collectors.toList());

        Assertions.assertEquals(20, result.size());
    }
}
