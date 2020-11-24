package ir.ac.tick.soft.source;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class TestClassDemo {

    @Test
    void methodName_blah_blah() {}

    @ParameterizedTest
    void methodName1_blah_blah() {}

    @Nested
    class Inner {
        @Test
        void methodName_blah_blah(){}
    }

}
