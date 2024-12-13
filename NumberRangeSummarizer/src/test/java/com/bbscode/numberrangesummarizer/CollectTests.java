package com.bbscode.numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CollectTests {

    /*
     * Provided Test Case
     */
    @Test
    public void providedTest() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        List<Integer> trueList = List.of(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);

        assertEquals(trueList, rangeTest.collect(testString));

    }

    /**
     * Tests single number parsing.
     */
    @Test
    public void singleNumber() {

        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1";
        List<Integer> trueList = List.of(1);
        assertEquals(trueList, rangeTest.collect(testString));

        testString = "50";

        List<Integer> trueList2 = List.of(50);
        assertEquals(trueList2, rangeTest.collect(testString));

        testString = "100";
        List<Integer> trueList3 = List.of(100);
        assertEquals(trueList3, rangeTest.collect(testString));

    }

    /**
     * Tests sequence parsing
     */
    @Test
    public void multipleNumbers() {

        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1,2,5,10";

        List<Integer> trueList = List.of(1, 2, 5, 10);
        assertEquals(trueList, rangeTest.collect(testString));

        testString = "100,400,600,1508";
        List<Integer> trueList2 = List.of(100, 400, 600, 1508);
        assertEquals(trueList2, rangeTest.collect(testString));
    }

    /**
     * Tests input with spaces
     */
    @Test
    public void spacesIncluded() {

        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1, 2, 5 ,10";
        List<Integer> trueList = List.of(1, 2, 5, 10);
        assertEquals(trueList, rangeTest.collect(testString));

        testString = " 100, 400,600,1508  ";
        List<Integer> trueList2 = List.of(100, 400, 600, 1508);
        assertEquals(trueList2, rangeTest.collect(testString));
    }

    /**
     * Tests empty input
     */
    @Test
    public void emptyList() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "";
        assertEquals(Collections.emptyList(), rangeTest.collect(testString));
        assertEquals(Collections.emptyList(), rangeTest.collect(null));
    }

}
