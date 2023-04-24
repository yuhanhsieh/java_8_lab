package lab.stream;

import lab.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {

    @Test
    public void filterAdultPerson() {
        List<Person> manyPeople = makePersonList();
        List<Person> adultPeople = manyPeople
                .stream()
                .filter(person -> person.age > 18)
                .collect(Collectors.toList());

        List<Person> expected = new ArrayList<>();
        expected.add(new Person("444",20));
        expected.add(new Person("555",35));

        Assertions.assertEquals(expected, adultPeople);
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
