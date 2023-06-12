# Calimoto Java Challenge

This project is my solution for the Calimoto recruitment test backend Java.

## Task 1

Since a Grandparent also is a parent and also can be a child, I chose only to have one model: [Person](/src/main/java/model/Person.java). This way things can be future-proof, allowing for even more generations to be added without the need for new explicit models.

In order to make the model testable I opted to move the printing logic to a service: [PersonService](/src/main/java/service/PersonService.java)

The sorting logic is in a helper service: [PersonSorter](/src/main/java/service/PersonSorter.java)

I added Unit and Integration tests and the test coverage is 100%.
