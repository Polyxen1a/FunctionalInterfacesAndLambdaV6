package com.example.functionalinterfacesandlambdav6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    void checksWhenPositive() {
        assertTrue(Main.verification(1));
        assertFalse(Main.verification(0));
    }

    @Test
    void checksWhenNegative() {
        assertFalse(Main.verification(-1));
    }
}