package lab.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class ReduceTest {

    @Test
    public void reduce_sumAll() {
        Stream<Integer> values = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = values.reduce(0, Integer::sum);

        Assertions.assertEquals(55, sum);
    }
}
