package ir.ac.tick.soft.source.dynamic.test;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DynamicTestsDemo {

    @TestFactory
    Stream<DynamicTest> generateRandomNumberOfTestsFromIterator() {

        Iterator<Integer> inputGenerator = new Iterator<Integer>() {

            final Random random = new Random();
            int current;

            @Override
            public boolean hasNext() {
                current = random.nextInt(100);
                return current % 7 != 0;
            }

            @Override
            public Integer next() {
                return current;
            }
        };

        // Generates display names like: input:5, input:37, input:85, etc.
        Function<Integer, String> displayNameGenerator = (input) -> "input:" + input;

        // Executes tests based on the current input value.
        ThrowingConsumer<Integer> testExecutor = (input) -> assertTrue(input % 7 != 0);

        // Returns a stream of dynamic tests.
        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamFactoryMethod() {
        Stream<String> inputStream = Stream.of("Ramin", "Razak", "Reza", "Ramtin");

        Function<String, String> displayNameGenerator = text -> text + " is start with 'ra'";

        ThrowingConsumer<String> testExecutor = text -> assertTrue(text.startsWith("Ra"));

        // Returns a stream of dynamic tests.
        return DynamicTest.stream(inputStream, displayNameGenerator, testExecutor);
    }

}