package ir.ac.tick.soft.source.repeated.test;

import ir.ac.tick.soft.source.Calculator;
import ir.ac.tick.soft.source.Translator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepeatedTestDemo {

    private Translator translator = new Translator();

    @RepeatedTest(10)
    void multiply_twoNumber_returnCorrectResult() {
        Calculator cal = new Calculator();
        int actual = cal.multiply(2, 2);
        Assertions.assertEquals(4,actual);
    }

    @RepeatedTest(15)
    void translate_simpleSentence_returnTranslatedSentence() {
        String actual = translator.translate("من برنامه نویسی را دوست دارم.");
        Assertions.assertEquals(actual, "I love unit testing.");
    }


}
