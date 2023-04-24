package lab.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {
    
    @Test
    public void collectToList() {
        Stream<String> values = Stream.of("bb", "cc", "dd");

        List<String> result = values.collect(Collectors.toList());

        List<String> expected = new ArrayList<>();
        expected.add("bb");
        expected.add("cc");
        expected.add("dd");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void collectToSet() {
        Stream<String> values = Stream.of("bb", "cc", "dd");

        Set<String> result = values.collect(Collectors.toSet());

        Set<String> expected = new HashSet<>();
        expected.add("bb");
        expected.add("cc");
        expected.add("dd");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void join() {
        Stream<String> values = Stream.of("bb", "cc", "dd");

        String result = values.collect(Collectors.joining(","));

        String expected = "bb,cc,dd";
        Assertions.assertEquals(expected, result);
    }

}
