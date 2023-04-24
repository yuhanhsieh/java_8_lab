package lab.stream;

import lab.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectToMapTest {

    @Test
    public void collectToMap() {
        List<Person> manyPeople = makePersonList();

        Map<String, Integer> result = manyPeople.stream().collect(Collectors.toMap(Person::getId, Person::getAge));

        Map<String, Integer> expected = new HashMap<>();
        expected.put("111",5);
        expected.put("222",10);
        expected.put("333",17);
        expected.put("444",20);
        expected.put("555",35);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void collectToMap_identity() {
        List<Person> manyPeople = makePersonList();

        Map<String, Person> result = manyPeople.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

        Map<String, Person> expected = new HashMap<>();
        expected.put("111", new Person("111",5));
        expected.put("222", new Person("222",10));
        expected.put("333", new Person("333",17));
        expected.put("444", new Person("444",20));
        expected.put("555", new Person("555",35));
        Assertions.assertEquals(expected, result);
    }

    private List<Person> makePersonList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("111",5));
        personList.add(new Person("222",10));
        personList.add(new Person("333",17));
        personList.add(new Person("444",20));
        personList.add(new Person("555",35));
        return personList;
    }
}
