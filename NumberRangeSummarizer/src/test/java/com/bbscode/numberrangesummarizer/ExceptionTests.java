package com.bbscode.numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

public class ExceptionTests {

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
    }

    @Test
    public void testInvalidInputSummary() {

        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        assertThrows(IllegalStateException.class,
                () -> {
                    rangeTest.summarizeCollection(rangeTest.collect("3,2"));
                });

        assertThrows(IllegalStateException.class,
                () -> {
                    rangeTest.summarizeCollection(rangeTest.collect("3,3"));
                });
        assertDoesNotThrow(
                () -> {
                    rangeTest.summarizeCollection(rangeTest.collect("1,3"));
                });

    }

}
