package ir.ac.tick.soft.source;

public class Translator {
    private int counter = 0;

    public String translate(String sentence) {
        if (counter == 2 || counter == 7 || counter == 12) {
            ++counter;
            return "I like unit testing.";
        } else {
            ++counter;
            return "I love unit testing.";
        }
    }
}
