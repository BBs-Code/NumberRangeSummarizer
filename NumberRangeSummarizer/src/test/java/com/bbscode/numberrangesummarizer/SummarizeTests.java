package com.bbscode.numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SummarizeTests {

    /**
     * Provided Test Case
     */
    @Test
    public void providedTest() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    /**
     * Tests Single Digits
     */
    @Test
    public void singleDigits() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1";
        String expectedResult = "1";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "10";
        expectedResult = "10";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    /**
     * Tests Empty List
     */
    @Test
    public void emptyList() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "";
        assertEquals(testString, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    /**
     * Tests sequences with no ranges
     */
    @Test
    public void noRanges() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1, 3, 5, 10";
        assertEquals(testString, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "50, 95, 156, 788";
        assertEquals(testString, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    /**
     * Tests sequences that consist of a single range
     */
    @Test
    public void singleRange() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1, 2";
        String expectedResult = "1-2";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "1,2,3,4,5";
        expectedResult = "1-5";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    /**
     * Tests sequences consisting of only ranges
     */
    @Test
    public void multipleRange() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1,2,9,10,11";
        String expectedResult = "1-2, 9-11";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "13,14,16,17, 22,23";
        expectedResult = "13-14, 16-17, 22-23";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "1,2,3,4,5,7,8,9,20,21,22";
        expectedResult = "1-5, 7-9, 20-22";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    /**
     * Tests sequences with a combination of ranges and single digits
     */
    @Test
    public void mixedTests() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1, 2, 5, 9, 10, 11, 22, 91";
        String expectedResult = "1-2, 5, 9-11, 22, 91";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "13,14,16,17, 22,23, 25, 27, 90,91";
        expectedResult = "13-14, 16-17, 22-23, 25, 27, 90-91";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "1,2,3,4,5,7,8,9,13,15,20,21,22";
        expectedResult = "1-5, 7-9, 13, 15, 20-22";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    /**
     * Tests sequences out of order data to test sorting
     */
    @Test
    public void unsortedInput() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "22, 91, 1, 5, 9, 10, 11,2 ";
        String expectedResult = "1-2, 5, 9-11, 22, 91";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "13,14,22,23,16,90,17, 27, 91, 25";
        expectedResult = "13-14, 16-17, 22-23, 25, 27, 90-91";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "1,2,9,13,4,5,7,15,20,21,22,3,8";
        expectedResult = "1-5, 7-9, 13, 15, 20-22";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

    /**
     * Tests sequences with duplicates to ensure they are removed
     */
    @Test
    public void duplicateInput() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1, 2, 2, 5,5, 9, 10, 11,11, 22, 91";
        String expectedResult = "1-2, 5, 9-11, 22, 91";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "13,14,16,17,17,22, 22,23, 25, 27, 90,91";
        expectedResult = "13-14, 16-17, 22-23, 25, 27, 90-91";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

        testString = "1,2,3,4,5,7,8,9,13,15,20,21,22,1,2,3,4,5,7,8,9,13,15,20,21,22";
        expectedResult = "1-5, 7-9, 13, 15, 20-22";
        assertEquals(expectedResult, rangeTest.summarizeCollection(rangeTest.collect(testString)));

    }

}