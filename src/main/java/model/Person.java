package model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Builder
@Data
public class Person {
    private LocalDate dateOfBirth;
    private Integer heightInCm;
    private String name;
    private List<Person> children;
    private List<Person> parents;

    public Integer getAgeInYears() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public String getInfoAboutPerson() {
        // TODO refactor to be easier extendable
        return "Name: " + name + "; Age in years: " + getAgeInYears() + "; Height in cm: " + heightInCm + ";";
    }
}
