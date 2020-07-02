/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
Make sure the returned intervals are also sorted.
 */

package Arrays;

import java.util.ArrayList;

/**
 * Definition for an interval.
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {

    /**
     * Given a set of sorted & non-overlapping interval, insert a new interval & merge if required
     * @param intervals
     * @param newInterval
     * @return
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> finalIntervals = new ArrayList<Interval>();

        for(Interval interval: intervals){
            // current interval's end in smaller than new interval's start, so there's no overlap
            if(interval.end < newInterval.start){
                finalIntervals.add(interval);
            }
            // current interval's start in bigger than new interval's end, so there's no overlap
            else if(interval.start > newInterval.end){
                finalIntervals.add(newInterval);
                newInterval = interval;
            }
            // overlapping interval, merging is required
            else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }

        finalIntervals.add(newInterval);

        return finalIntervals;
    }
}
