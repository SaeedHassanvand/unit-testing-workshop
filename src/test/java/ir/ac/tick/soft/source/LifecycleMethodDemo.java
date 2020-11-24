package ir.ac.tick.soft.source;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class LifecycleMethodDemo {

    private List<String> list;

    private static List<String> list2;

    @BeforeAll
    static void initAll() {
        list2 = new ArrayList<String>();
        list2.add("apple");
        list2.add("orange");
        list2.add("banana");
    }

    @BeforeEach
    void init() {
        list = new ArrayList<String>();
        list.addAll(list2);
    }

    @Test
    void remove_blah_blah() {
        list.remove("apple");
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    void clear_blah_blah() {
        list.clear();
        Assertions.assertEquals(list.size(), 0);
    }

}
