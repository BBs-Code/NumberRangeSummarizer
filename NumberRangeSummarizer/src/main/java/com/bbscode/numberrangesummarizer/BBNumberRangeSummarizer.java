package com.bbscode.numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class BBNumberRangeSummarizer implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {

        if (input.length() == 0) {
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

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        if (input.size() == 0) {
            return "";
        }

        StringBuilder summary = new StringBuilder();
        Iterator<Integer> iter = input.iterator();

        Integer cur = iter.next();
        while (iter.hasNext()) {
            summary.append(cur);
            Integer next = iter.next();
            if (cur >= next) {
                throw new IllegalStateException("Input provided is not in ascending order and unique.");
            }
            if (next != cur + 1) {
                summary.append(",");
                cur = next;
            } else {
                summary.append("-");
                if (!iter.hasNext()) {
                    summary.append(next);
                    return summary.toString();
                }
                Integer endRange = next;
                while ((next = iter.next()) == endRange + 1) {
                    endRange = next;
                    if (!iter.hasNext()) {
                        summary.append(next);
                        return summary.toString();
                    }
                }
                summary.append(endRange + ",");
                cur = next;
            }

        }
        summary.append(cur);

        return summary.toString();

    }

}
