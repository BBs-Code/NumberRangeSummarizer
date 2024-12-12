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
            range.add(Integer.parseInt(input.substring(start, end).trim()));
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
            summary.append(Integer.toString(cur));
            Integer next = iter.next();
            if (next != cur + 1) {
                summary.append(",");
                cur = next;
            }

        }
        summary.append(Integer.toString(cur));

        return summary.toString();

    }

}
