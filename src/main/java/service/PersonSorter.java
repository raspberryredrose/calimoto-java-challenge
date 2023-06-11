package service;

import model.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonSorter {
    public static List<Person> sortPersonListByAge(List<Person> personList, Boolean ascending) {
        List<Person> sortedList = personList.stream().sorted(Comparator.comparing(Person::getDateOfBirth)).collect(Collectors.toList());
        if (!ascending) {
            Collections.reverse(sortedList);
        }
        return sortedList;
    }

    public static List<Person> sortPersonListByHeight(List<Person> personList, Boolean ascending) {
        List<Person> sortedList = personList.stream().sorted(Comparator.comparingInt(Person::getHeightInCm)).collect(Collectors.toList());
        if (!ascending) {
            Collections.reverse(sortedList);
        }
        return sortedList;
    }
}
