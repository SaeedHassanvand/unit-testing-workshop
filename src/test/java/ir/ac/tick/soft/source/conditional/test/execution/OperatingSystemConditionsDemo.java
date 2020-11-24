package ir.ac.tick.soft.source.conditional.test.execution;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.condition.OS.*;

public class OperatingSystemConditionsDemo {

    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        // ...
    }

    @Test
    @EnabledOnOs({ LINUX, MAC })
    void onLinuxOrMac() {
        // ...
    }

    @Test
    @EnabledOnOs(WINDOWS)
    void notOnWindows() {
        // ...
    }
}
