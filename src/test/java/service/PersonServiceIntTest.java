package service;

import model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonServiceIntTest {
    private final String PRINT_RESULTS_PATH = "src/test/resources/service/person_service_int_test/";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testPrintChildren_hasNoChildren() throws IOException {
        Person person = Person.builder()
                .name("Hans")
                .build();
        PersonService.printChildren(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintChildren_hasNoChildren.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintChildren_hasOneChild() throws IOException {
        Person child = Person.builder()
                .name("Child 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person person = Person.builder()
                .name("Hans")
                .children(List.of(child))
                .build();
        PersonService.printChildren(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintChildren_hasOneChild.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintChildren_hasTwoChildren() throws IOException {
        Person child1 = Person.builder()
                .name("Child 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person child2 = Person.builder()
                .name("Child 2")
                .dateOfBirth(LocalDate.of(1987, 12, 1))
                .heightInCm(120)
                .build();
        Person person = Person.builder()
                .name("Hans")
                .children(List.of(child1, child2))
                .build();
        PersonService.printChildren(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintChildren_hasTwoChildren.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintParents_hasNoParents() throws IOException {
        Person person = Person.builder()
                .name("Hans")
                .build();
        PersonService.printParents(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintParents_hasNoParents.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintParents_hasOneParent() throws IOException {
        Person parent = Person.builder()
                .name("Parent 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person person = Person.builder()
                .name("Hans")
                .parents(List.of(parent))
                .build();
        PersonService.printParents(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintParents_hasOneParent.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintParents_hasTwoParents() throws IOException {
        Person parent1 = Person.builder()
                .name("Parent 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person parent2 = Person.builder()
                .name("Parent 2")
                .dateOfBirth(LocalDate.of(1987, 12, 1))
                .heightInCm(120)
                .build();
        Person person = Person.builder()
                .name("Hans")
                .parents(List.of(parent1, parent2))
                .build();
        PersonService.printParents(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintParents_hasTwoParents.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintGrandchildren_hasNoChildren() throws IOException {
        Person person = Person.builder()
                .name("Hans")
                .build();
        PersonService.printGrandchildren(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintGrandchildren_hasNoChildren.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintGrandchildren_hasNoGrandchildren() throws IOException {
        Person child = Person.builder().build();
        Person person = Person.builder()
                .name("Hans")
                .children(List.of(child))
                .build();
        PersonService.printGrandchildren(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintGrandchildren_hasNoGrandchildren.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintGrandchildren_hasOneGrandchild() throws IOException {
        Person grandchild = Person.builder()
                .name("Grandchild 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person child = Person.builder()
                .children(List.of(grandchild))
                .build();
        Person person = Person.builder()
                .name("Hans")
                .children(List.of(child))
                .build();
        PersonService.printGrandchildren(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintGrandchildren_hasOneGrandchild.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintGrandchildren_hasTwoGrandchildrenFromTwoChildren() throws IOException {
        Person grandchild1 = Person.builder()
                .name("Grandchild 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person grandchild2 = Person.builder()
                .name("Grandchild 2")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person child1 = Person.builder()
                .children(List.of(grandchild1))
                .build();
        Person child2 = Person.builder()
                .children(List.of(grandchild2))
                .build();
        Person person = Person.builder()
                .name("Hans")
                .children(List.of(child1, child2))
                .build();
        PersonService.printGrandchildren(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintGrandchildren_hasTwoGrandchildrenFromTwoChildren.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintGrandparents_hasNoParents() throws IOException {
        Person person = Person.builder()
                .name("Hans")
                .build();
        PersonService.printGrandparents(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintGrandparents_hasNoParents.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintGrandparents_hasNoGrandparents() throws IOException {
        Person parent = Person.builder().build();
        Person person = Person.builder()
                .name("Hans")
                .parents(List.of(parent))
                .build();
        PersonService.printGrandparents(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintGrandparents_hasNoGrandparents.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintGrandparents_hasOneGrandparent() throws IOException {
        Person grandparent = Person.builder()
                .name("Grandparent 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person parent = Person.builder()
                .parents(List.of(grandparent))
                .build();
        Person person = Person.builder()
                .name("Hans")
                .parents(List.of(parent))
                .build();
        PersonService.printGrandparents(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintGrandparents_hasOneGrandparent.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintGrandparents_hasTwoGrandparentsFromTwoParents() throws IOException {
        Person grandparent1 = Person.builder()
                .name("Grandparent 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person grandparent2 = Person.builder()
                .name("Grandparent 2")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person parent1 = Person.builder()
                .parents(List.of(grandparent1))
                .build();
        Person parent2 = Person.builder()
                .parents(List.of(grandparent2))
                .build();
        Person person = Person.builder()
                .name("Hans")
                .parents(List.of(parent1, parent2))
                .build();
        PersonService.printGrandparents(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintGrandparents_hasTwoGrandparentsFromTwoParents.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void testPrintAllInfoAboutPerson() throws IOException {
        Person grandchild1 = Person.builder()
                .name("Grandchild 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person grandchild2 = Person.builder()
                .name("Grandchild 2")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person child1 = Person.builder()
                .name("Child 1")
                .children(List.of(grandchild1))
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person child2 = Person.builder()
                .name("Child 2")
                .children(List.of(grandchild2))
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person grandparent1 = Person.builder()
                .name("Grandparent 1")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person grandparent2 = Person.builder()
                .name("Grandparent 2")
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person parent1 = Person.builder()
                .name("Parent 1")
                .parents(List.of(grandparent1))
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();
        Person parent2 = Person.builder()
                .name("Parent 2")
                .parents(List.of(grandparent2))
                .dateOfBirth(LocalDate.of(1967, 12, 1))
                .heightInCm(120)
                .build();

        Person person = Person.builder()
                .name("Hans")
                .dateOfBirth(LocalDate.of(1999, 5,6))
                .heightInCm(170)
                .children(List.of(child1, child2))
                .parents(List.of(parent1, parent2))
                .build();

        PersonService.printAllInfoAboutPerson(person);

        Path filePath = Path.of(PRINT_RESULTS_PATH + "testPrintAllInfoAboutPerson.txt");
        String expected = Files.readString(filePath);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}
