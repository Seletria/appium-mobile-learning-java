package com.qa.automation.mobile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmokeTest {

    @Test
    void shouldAddTwoNumbers() {
        int result = 2 + 3;
        assertEquals(5, result);
    }
}
