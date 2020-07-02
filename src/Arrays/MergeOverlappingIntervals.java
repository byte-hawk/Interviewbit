/*
Given a collection of intervals, merge all overlapping intervals.
For example:

Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.
 */

package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class MergeOverlappingIntervals {

    /**
     * Given a set of overlapping intervals, merge them and create a set of non-overlapping intervals
     * @param intervals
     * @return
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> finalIntervals = new ArrayList<>();
        Collections.sort(intervals, Comparator.comparing((Interval it)->it.start));

        Interval temp = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval cur = intervals.get(i);
            // Current interval's start is lower than previous interval's end, the intervals are overlapping
            if(cur.start <= temp.end){
                temp.end = Math.max(temp.end, cur.end);
            }
            // Non overlapping scenario
            else{
                finalIntervals.add(temp);
                temp = cur;
            }
        }

        finalIntervals.add(temp);
        return finalIntervals;
    }
}
