package org.example.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Test3Test {
    @BeforeEach
    void beforeeach() {
//        System.out.println("aaa");
    }

    @Test
    void getReverse() {
        System.out.println("reverse");
        assertEquals(TestIn.getReverse("a@b"), "b@a");
    }
}