package ir.ac.tick.soft.source.assertions;

import ir.ac.tick.soft.source.Calculator;
import ir.ac.tick.soft.source.Person;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {

    private Person person = new Person("Ali", "Akbari");

    @Test
    void standardAssertions() {
        Calculator calculator = new Calculator();
        int actual = calculator.add(2, 2);
        assertEquals(actual, 4);

        actual = calculator.multiply(2, 3);
        assertEquals(actual, 6, "Sample message!");

        actual = calculator.divide(6, 2);
        assertEquals(actual, 3, () -> "Complex Message!");
    }

    @Test
    void groupAssertions() {
        assertAll("person",
                () -> assertEquals("Ali", person.getFirstName()),
                () -> assertEquals("Akbari", person.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        assertAll("personProperties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);
                    assertAll("firstName",
                            () -> assertTrue(firstName.startsWith("A")),
                            () -> assertTrue((firstName.endsWith("i")))
                    );
                },
                () -> {
                    String lastName = person.getLastName();
                    assertNotNull(lastName);
                    assertAll("lastName",
                            () -> assertTrue(lastName.startsWith("A")),
                            () -> assertTrue((lastName.endsWith("i"))));
                }
        );
    }

    @Test
    void exceptionTesting() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void exceptionTestingOtherApproach() {
        Calculator calculator = new Calculator();
        try {
            calculator.divide(1, 0);
            fail("Exception has not been thrown!");
        } catch (ArithmeticException ignored) {

        }
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMinutes(2), () -> {
            // Performs task that takes less than 2 min.
        });
    }

    @Test
    void timeoutExceeded() {
        assertTimeout(Duration.ofMillis(250), () -> {
            Thread.sleep(200);
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        String actual = assertTimeout(Duration.ofSeconds(10), () -> {
            return "Hello World!";
        });

        assertEquals("Hello World!", actual);
    }

    @Test
    void timeoutNotExceededWithMethod() {
        String actual = assertTimeout(Duration.ofSeconds(5), AssertionsDemo::sayHelloToWorld);
        assertEquals("Hello World!", actual);
    }

    private static String sayHelloToWorld() {
        return "Hello World!";
    }
}
