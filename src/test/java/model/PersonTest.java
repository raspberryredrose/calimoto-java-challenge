package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

// TODO Mock clock so that the test won't start failing next year
public class PersonTest {
    @Test
    void testGetAgeInYears() {
        Person person = Person.builder()
                .dateOfBirth(LocalDate.of(1996, 4, 3))
                .heightInCm(162)
                .name("Peter Lustig Reloaded")
                .build();
        Integer age = person.getAgeInYears();
        assertEquals(27, age);
    }

    @Test
    void testPrintInfoAboutPerson() {
        Person person = Person.builder()
                .dateOfBirth(LocalDate.of(1996, 4, 3))
                .heightInCm(162)
                .name("Peter Lustig Reloaded")
                .build();
        String expectedString = "Name: Peter Lustig Reloaded; Age in years: 27; Height in cm: 162;";
        assertEquals(expectedString, person.getInfoAboutPerson());
    }
}
