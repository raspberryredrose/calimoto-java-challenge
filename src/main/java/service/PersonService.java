package service;

import model.Person;

import java.util.List;

// TODO maybe refactor to remove duplicated code
public class PersonService {
    public static void printInfoAboutPerson(Person person) {
        String personInfo = person.getInfoAboutPerson();
        System.out.println(personInfo);
    }

    public static void printAllInfoAboutPerson(Person person) {
        printInfoAboutPerson(person);
        printParents(person);
        printChildren(person);
        printGrandparents(person);
        printGrandchildren(person);
    }

    public static void printChildren(Person person) {
        List<Person> children = person.getChildren();
        if(isListValid(children)) {
            System.out.println(person.getName() + " has the following children:");
            children.forEach(PersonService::printInfoAboutPerson);
        } else {
            System.out.println(person.getName() + " has no children.");
        }
    }

    public static void printGrandchildren(Person person) {
        List<Person> children = person.getChildren();
        if (children == null || children.isEmpty()) {
            System.out.println(person.getName() + " has no grandchildren.");
            return;
        }
        System.out.println(person.getName() + " has the following grandchildren:");
        children.forEach(child -> {
            List<Person> grandchildren = child.getChildren();
            if(isListValid(grandchildren)) {
                grandchildren.forEach(PersonService::printInfoAboutPerson);
            } else {
                System.out.println("None");
            }
        });
    }

    public static void printParents(Person person) {
        List<Person> parents = person.getParents();
        if(isListValid(parents)) {
            System.out.println(person.getName() + " has the following parents:");
            parents.forEach(PersonService::printInfoAboutPerson);
        } else {
            System.out.println(person.getName() + " has no parents.");
        }
    }

    public static void printGrandparents(Person person) {
        List<Person> parents = person.getParents();
        if (parents == null || parents.isEmpty()) {
            System.out.println(person.getName() + " has no grandparents.");
            return;
        }
        System.out.println(person.getName() + " has the following grandparents:");
        parents.forEach(parent -> {
            List<Person> grandparents = parent.getParents();
            if(isListValid(grandparents)) {
                grandparents.forEach(PersonService::printInfoAboutPerson);
            } else {
                System.out.println("None");
            }
        });
    }

    private static Boolean isListValid(List<Person> personList) {
        return personList != null && !personList.isEmpty();
    }

}
