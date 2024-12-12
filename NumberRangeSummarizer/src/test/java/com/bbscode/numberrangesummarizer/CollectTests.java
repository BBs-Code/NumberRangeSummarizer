package com.bbscode.numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class CollectTests {

    /**
     * Tests single number parsing.
     */
    @Test
    public void singleNumber() {

        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1";
        ArrayList<Integer> trueList = new ArrayList<Integer>();
        trueList.add(1);
        assertEquals(trueList, rangeTest.collect(testString));

        testString = "50";
        trueList.clear();
        trueList.add(50);
        assertEquals(trueList, rangeTest.collect(testString));

        testString = "100";
        trueList.clear();
        trueList.add(100);
        assertEquals(trueList, rangeTest.collect(testString));

    }

    /**
     * Tests multiple number parsing
     */
    @Test
    public void multipleNumbers() {

        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1,2,5,10";
        ArrayList<Integer> trueList = new ArrayList<Integer>();
        trueList.add(1);
        trueList.add(2);
        trueList.add(5);
        trueList.add(10);
        assertEquals(trueList, rangeTest.collect(testString));

        trueList.clear();
        testString = "100,400,600,1508";
        trueList.add(100);
        trueList.add(400);
        trueList.add(600);
        trueList.add(1508);
        assertEquals(trueList, rangeTest.collect(testString));
    }

    /**
     * Tests input with spaces
     */
    @Test
    public void spacesIncluded() {

        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "1, 2, 5 ,10";
        ArrayList<Integer> trueList = new ArrayList<Integer>();
        trueList.add(1);
        trueList.add(2);
        trueList.add(5);
        trueList.add(10);
        assertEquals(trueList, rangeTest.collect(testString));

        trueList.clear();
        testString = " 100, 400,600,1508  ";
        trueList.add(100);
        trueList.add(400);
        trueList.add(600);
        trueList.add(1508);
        assertEquals(trueList, rangeTest.collect(testString));
    }

    /**
     * Tests empty input
     */

    @Test
    public void emptyList() {
        BBNumberRangeSummarizer rangeTest = new BBNumberRangeSummarizer();
        String testString = "";
        assertEquals(Collections.emptyList(), rangeTest.collect(testString));

    }

}
