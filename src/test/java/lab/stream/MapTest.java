package lab.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {

    @Test
    public void convertToLowcase_success() {
        List<String> upperCaseWords = Arrays.asList("ABCDE", "XYZ");

        List<String> stringStream = upperCaseWords
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        List<String> expected =Arrays.asList("abcde", "xyz");
        Assertions.assertEquals(expected, stringStream);
    }
}
