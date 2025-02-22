package com.introtoarrays;

import com.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        final List<Interval> result = generateMergedSortedIntervals();
        System.out.println();
        result.forEach(System.out::println);
        System.out.println();
        final List<Interval> result2 = generateSortedNonOverlappingIntervals();
        System.out.println();
        result2.forEach(System.out::println);
        System.out.println();
    }
    private static List<Interval> generateMergedSortedIntervals() {
        System.out.print("MERGE SORTED INTERVALS ");
        final Interval interval1 = new Interval();
        interval1.setStart(0);
        interval1.setEnd(2);
        final Interval interval2 = new Interval();
        interval2.setStart(1);
        interval2.setEnd(4);
        final Interval interval3 = new Interval();
        interval3.setStart(3);
        interval3.setEnd(6);
        final Interval interval4 = new Interval();
        interval4.setStart(7);
        interval4.setEnd(10);
        final Interval interval5 = new Interval();
        interval5.setStart(11);
        interval5.setEnd(12);
        final List<Interval> input = Arrays.asList(interval1, interval2, interval3, interval4, interval5);
        return mergeSortedIntervals(input);
    }

    private static List<Interval> generateSortedNonOverlappingIntervals() {
        System.out.print("MERGE SORTED OVERLAPPING INTERVALS WITH AN INPUT INTERVAL ");
        final Interval interval1 = new Interval();
        interval1.setStart(1);
        interval1.setEnd(3);
        final Interval interval2 = new Interval();
        interval2.setStart(4);
        interval2.setEnd(7);
        final Interval interval3 = new Interval();
        interval3.setStart(10);
        interval3.setEnd(14);
        final Interval interval4 = new Interval();
        interval4.setStart(16);
        interval4.setEnd(19);
        final Interval interval5 = new Interval();
        interval5.setStart(21);
        interval5.setEnd(24);
        final Interval interval6 = new Interval();
        interval6.setStart(27);
        interval6.setEnd(30);
        final Interval interval7 = new Interval();
        interval7.setStart(32);
        interval7.setEnd(35);
        final Interval interval8 = new Interval();
        interval8.setStart(38);
        interval8.setEnd(41);
        final Interval interval9 = new Interval();
        interval9.setStart(43);
        interval9.setEnd(50);
        final List<Interval> intervals = Arrays.asList(interval1, interval2, interval3, interval4, interval5, interval6,
                interval7, interval8, interval9);
        final Interval input = new Interval();
        input.setStart(12);
        input.setEnd(22);
        return mergeSortedNonOverlappingIntervals(intervals, input);
    }

    private static List<Interval> mergeSortedIntervals(final List<Interval> input) {
        final List<Interval> nonOverlappingIntervals = new ArrayList<>();
        Interval current = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            final Interval next = input.get(i);
            if (next.getStart().compareTo(current.getEnd()) > 0) {
                nonOverlappingIntervals.add(current);
                current = next;
            } else {
                current.setStart(Math.min(current.getStart(), next.getStart()));
                current.setEnd(Math.max(current.getEnd(), next.getEnd()));
            }
        }
        nonOverlappingIntervals.add(current);
        return nonOverlappingIntervals;
    }

    private static List<Interval> mergeSortedNonOverlappingIntervals(final List<Interval> intervals, final Interval input) {
        final List<Interval> nonOverlappingIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.getEnd().compareTo(input.getStart()) < 0) {
                nonOverlappingIntervals.add(current);
            } else if (current.getStart().compareTo(input.getEnd()) > 0){
                nonOverlappingIntervals.add(input);
                for (int j = i; j < intervals.size(); j++) {
                    nonOverlappingIntervals.add(intervals.get(j));
                }
                return nonOverlappingIntervals;
            } else {
                input.setStart(Math.min(input.getStart(), current.getStart()));
                input.setEnd(Math.max(input.getEnd(), current.getEnd()));
            }
        }
        return nonOverlappingIntervals;
    }
}
