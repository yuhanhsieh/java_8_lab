package lab.stream;

import lab.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingTest {

    @Test
    public void grouping() {
        Map<String, List<Locale>> conuntryToLocales =
                Stream.of(Locale.getAvailableLocales()).collect(Collectors.groupingBy(Locale::getCountry));

        List<Locale> result = conuntryToLocales.get("CH");

        List<Locale> expected = new ArrayList<>();
        expected.add(new Locale("fr", "CH"));
        expected.add(new Locale("de", "CH"));
        expected.add(new Locale("it", "CH"));

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void partitioning() {
        Map<Boolean, List<Locale>> englishAndOtherLocales =
                Stream.of(Locale.getAvailableLocales())
                        .collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        List<Locale> englishLocales = englishAndOtherLocales.get(true);

        List<Locale> expected = getExpected();

        Assertions.assertEquals(expected, englishLocales);
    }
    @Test
    public void counting() {
        Map<String, Long> conuntryToLocales =
                Stream.of(Locale.getAvailableLocales())
                        .collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));

        Stream<Person> personStream =
                Stream.of(new Person("aaa", 10), new Person("bbb", 30), new Person("ccc", 30));
        Map<Integer, Long> result = personStream.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

        long age10Count = result.get(10);
        long age30Count = result.get(30);

        Assertions.assertEquals(1, age10Count);
        Assertions.assertEquals(2, age30Count);
    }
    private static List<Locale> getExpected() {
        List<Locale> expected = new ArrayList<>();
        expected.add(new Locale("en", "US"));
        expected.add(new Locale("en", "SG"));
        expected.add(new Locale("en", "MT"));
        expected.add(new Locale("en"));
        expected.add(new Locale("en", "PH"));
        expected.add(new Locale("en", "NZ"));
        expected.add(new Locale("en", "ZA"));
        expected.add(new Locale("en","AU"));
        expected.add(new Locale("en","IE"));
        expected.add(new Locale("en","CA"));
        expected.add(new Locale("en","IN"));
        expected.add(new Locale("en","GB"));
        return expected;
    }
}
