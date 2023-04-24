package lab.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {

    @Test
    public void combineManyList() {
        List<String> list_1 = Stream.of("foo", "bar").collect(Collectors.toList());
        List<String> list_2 = Stream.of("hi", "hello").collect(Collectors.toList());
        List<String> list_3 = Stream.of("kero", "tama").collect(Collectors.toList());

        List<String> mergedList = Stream
                .of(list_1, list_2, list_3)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<String> expected = Stream.of("foo", "bar", "hi", "hello", "kero", "tama").collect(Collectors.toList());
        Assertions.assertEquals(expected, mergedList);
    }
}
