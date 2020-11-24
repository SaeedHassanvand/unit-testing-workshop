package ir.ac.tick.soft.source;

class Accumulator {

    private int value = 0;

    int add(int num) throws AccumulatorOutOfMemoryException {
        if (num < 0) {
            return value;
        }
        value = value + num;
        final int MAX_VALUE = 1000;
        if (value > MAX_VALUE) {
            throw new AccumulatorOutOfMemoryException();
        }
        return value;
    }

}
