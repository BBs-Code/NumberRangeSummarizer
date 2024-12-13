package com.bbscode.numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class BBNumberRangeSummarizer implements NumberRangeSummarizer {

    /**
     * Parses a comma delimited String of Integers and returns a Collection of
     * Integers.
     * Returns an empty list if the input is null or the empty String.
     * 
     * @param input - The String input to Parse
     * @return Collection<Integer> - Returns an ArrayList of Integers.
     * @exception NumberFormatException - Thrown if an invalid Integer is found
     *                                  during parsing.
     * 
     */
    @Override
    public Collection<Integer> collect(String input) {

        if (input == null || input.length() == 0) {
            return Collections.emptyList();
        }

        Collection<Integer> range = new ArrayList<Integer>();
        int start = 0;
        int end;

        while ((end = input.indexOf(",", start)) >= 0) {
            try {
                range.add(Integer.parseInt(input.substring(start, end).trim()));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid Integer in string at index " + (range.size() - 1) + ".");
            }
            start = end + 1;
        }

        range.add(Integer.parseInt(input.substring(start).trim()));

        return range;
    }

    /**
     * Converts a Collection of Integers into a String with the sequential Integers
     * colllapsed into ranges.
     * Allows for unsorted or non-unique inputs by removing the duplicates and
     * sorting the collection.
     * 
     * @param input - The collection to be converted
     * @return String - The String representation of the range.
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {

        if (input.size() == 0) {
            return "";
        }

        // Use a Tree Set to remove duplicates and sort the list
        ArrayList<Integer> inputArray = new ArrayList<Integer>(new TreeSet<Integer>(input));

        StringBuilder summary = new StringBuilder();

        for (int i = 0; i < inputArray.size(); i++) {
            Integer cur = inputArray.get(i);
            summary.append(cur);
            // Check if we have a range
            if ((i < inputArray.size() - 1) && cur + 1 == inputArray.get(i + 1)) {
                // Loop until we find the end of the range
                while ((i < inputArray.size() - 1) && cur + 1 == inputArray.get(i + 1)) {
                    i++;
                    cur = inputArray.get(i);
                }
                summary.append("-" + cur);
            }

            // If there are numbers left, add a comma
            if (i < inputArray.size() - 1) {
                summary.append(", ");
            }
        }

        return summary.toString();

    }

}
