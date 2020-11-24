package ir.ac.tick.soft.source;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccumulatorTest {

    private Accumulator acc1 = new Accumulator();

    @Test
    void test() throws Exception {
        Accumulator acc = new Accumulator();
        Assertions.assertEquals(acc.add(403), 403);
    }

    @Test
    void add_singleNumber_returnSameNumber() throws Exception {
        Accumulator acc = new Accumulator();
        Assertions.assertEquals(acc.add(403), 403);
    }

    @Test
    void add_singleNumber_returnSameNumber_withArrangement() throws Exception {
        //Arrange
        Accumulator acc = new Accumulator();

        //Act
        int actual = acc.add(403);

        //Assert
        Assertions.assertEquals(actual, 403);
    }

    @Test
    void add_singleNumber_returnSameNumber_withArrangement_better() throws Exception {
        //Arrange
        Accumulator acc = new Accumulator();

        //Act
        int actual = acc.add(1);

        //Assert
        Assertions.assertEquals(actual, 1);
    }

    @Test
    void add_addingBiggerNumberThanMax_throwException() {
        Accumulator acc = new Accumulator();
        try {
            acc.add(1001);
            Assertions.fail("An AccumulatorOutOfMemoryException was expected!");
        } catch (AccumulatorOutOfMemoryException exc) {
        }
    }

    @Test
    void add_addingBiggerNumberThanMax_throwException_better() {
        Accumulator acc = new Accumulator();
        final int MAX_VALUE = 1000;
        try {
            acc.add(MAX_VALUE + 1);
            Assertions.fail("An AccumulatorOutOfMemoryException was expected!");
        } catch (AccumulatorOutOfMemoryException exc) {
        }
    }


    @Test
    void add_multipleNumber_returnCorrectResult() throws Exception {
        Accumulator acc = new Accumulator();
        int[] testNumber = {0, 3, 3};
        int actual = 0;
        for (int number : testNumber) {
            Assertions.assertEquals(acc.add(number), actual);
            actual += 3;
        }
    }

    @ParameterizedTest
    @CsvSource({"0,0", "3,3", "3,6"})
    void add_multipleNumber_returnCorrectResult_better(int number, int expected) throws Exception {
        int actual = acc1.add(number);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void add_generalTest_returnCorrectResult() throws Exception {
        Accumulator acc = new Accumulator();
        int actual = acc.add(-1);
        Assertions.assertEquals(actual, 0);
        actual = acc.add(3);
        Assertions.assertEquals(actual, 3);
    }
}
