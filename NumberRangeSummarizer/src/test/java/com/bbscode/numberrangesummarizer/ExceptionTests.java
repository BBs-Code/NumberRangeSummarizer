package com.bbscode.numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ExceptionTests {

    /**
     * Tests that the collect function correctly throws exceptions with invalid
     * input
     */
    @Test
    public void testInvalidStringCollect() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        assertThrows(NumberFormatException.class,
                () -> {
                    rangeTest.summarizeCollection(rangeTest.collect("abc,2"));
                });
        assertThrows(NumberFormatException.class,
                () -> {
                    rangeTest.summarizeCollection(rangeTest.collect("13,14,-"));
                });
        assertThrows(NumberFormatException.class,
                () -> {
                    rangeTest.summarizeCollection(rangeTest.collect(",,"));
                });
        assertDoesNotThrow(
                () -> {
                    rangeTest.summarizeCollection(rangeTest.collect("1,2,3"));
                });
    }

}
