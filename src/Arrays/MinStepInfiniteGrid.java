/*
You are in an infinite 2D grid where you can move in any of the 8 directions
 (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.

NOTE: This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.

Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.

Output Format
Return an Integer, i.e minimum number of steps.

Example Input
Input 1:

 A = [0, 1, 1]
 B = [0, 1, 2]

Example Output
Output 1:
 2

Example Explanation
Explanation 1:
 Given three points are: (0, 0), (1, 1) and (1, 2).
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */

package Arrays;

import java.util.ArrayList;

public class MinStepInfiniteGrid {

    /*
    Approach:
        distance between 2 points (x1,y1) & (x2,y2) will be max(|x1-x2| , |y1-y2|)
    */

    /**
     * get minimum distance required for covering all points
     * @param A
     * @param B
     * @return
     */
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A == null || B == null || A.size() != B.size() || A.size()<2)   return 0;
        int n=A.size(), dist=0;

        for(int i=1; i<n; i++)
            dist += Math.max( Math.abs(A.get(i)-A.get(i-1)), Math.abs(B.get(i)-B.get(i-1)));

        return dist;
    }
}
