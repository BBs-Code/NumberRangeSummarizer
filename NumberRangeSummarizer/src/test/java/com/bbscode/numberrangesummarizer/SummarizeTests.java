package com.bbscode.numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

public class SummarizeTests {
    @Test
    public void noRanges() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1,3,5,10";
        assertEquals(testString, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "50,95,156,788";
        assertEquals(testString, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    @Test
    public void emptyList() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "";
        assertEquals(testString, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    @Test
    public void singleRange() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1,2,5,10";
        String result = "1-2,5,10";
        assertEquals(result, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "1,2,3,4,5,10";
        result = "1-5,10";
        assertEquals(result, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    @Test
    public void singleDigits() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1";
        String result = "1";
        assertEquals(result, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "10";
        result = "10";
        assertEquals(result, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    @Test
    public void multipleRange() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1,2,9,10";
        String result = "1-2,9-10";
        assertEquals(result, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "1,2,3,4,5,7,8,9,20,21,22";
        result = "1-5,7-9,20-22";
        assertEquals(result, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

}