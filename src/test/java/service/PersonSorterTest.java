package service;

import model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonSorterTest {
    @Test
    public void testSortPersonListByAge_ascending() {
        Person person1 = Person.builder()
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .build();
        Person person2 = Person.builder()
                .dateOfBirth(LocalDate.of(1988, 12, 1))
                .build();
        Person person3 = Person.builder()
                .dateOfBirth(LocalDate.of(1977, 12, 1))
                .build();
        List<Person> personListUnsorted = List.of(person1, person2, person3);
        List<Person> personListSorted = List.of(person1, person3, person2);

        List<Person> result = PersonSorter.sortPersonListByAge(personListUnsorted, true);

        assertEquals(personListSorted, result);
    }

    @Test
    public void testSortPersonListByAge_descending() {
        Person person1 = Person.builder()
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .build();
        Person person2 = Person.builder()
                .dateOfBirth(LocalDate.of(1988, 12, 1))
                .build();
        Person person3 = Person.builder()
                .dateOfBirth(LocalDate.of(1977, 12, 1))
                .build();
        List<Person> personListUnsorted = List.of(person1, person2, person3);
        List<Person> personListSorted = List.of(person2, person3, person1);

        List<Person> result = PersonSorter.sortPersonListByAge(personListUnsorted, false);

        assertEquals(personListSorted, result);
    }

    @Test
    public void testSortPersonListByHeight_ascending() {
        Person person1 = Person.builder()
                .heightInCm(170)
                .build();
        Person person2 = Person.builder()
                .heightInCm(120)
                .build();
        Person person3 = Person.builder()
                .heightInCm(166)
                .build();
        List<Person> personListUnsorted = List.of(person1, person2, person3);
        List<Person> personListSorted = List.of(person2, person3, person1);

        List<Person> result = PersonSorter.sortPersonListByHeight(personListUnsorted, true);

        assertEquals(personListSorted, result);
    }

    @Test
    public void testSortPersonListByHeight_descending() {
        Person person1 = Person.builder()
                .heightInCm(170)
                .build();
        Person person2 = Person.builder()
                .heightInCm(120)
                .build();
        Person person3 = Person.builder()
                .heightInCm(166)
                .build();
        List<Person> personListUnsorted = List.of(person1, person2, person3);
        List<Person> personListSorted = List.of(person1, person3, person2);

        List<Person> result = PersonSorter.sortPersonListByHeight(personListUnsorted, false);

        assertEquals(personListSorted, result);
    }
}
