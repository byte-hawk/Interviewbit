/*
Given an array A containing N integers.
You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
If no such triplet exist return 0.

Problem Constraints
3 <= N <= 105.
1 <= A[i] <= 108.

Input Format
First argument is an integer array A.

Output Format
Return a single integer denoting the maximum sum of triplet as described in the question.

Example Input
Input 1:
 A = [2, 5, 3, 1, 4, 9]
Input 2:
 A = [1, 2, 3]

Example Output
Output 1:
 16
Output 2:
 6

Example Explanation
Explanation 1:
 All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
  Maximum sum = 16

Explanation 2:
 All possible triplets are:-
    1 2 3 => sum = 6
 Maximum sum = 6
 */

package Arrays;

import java.util.ArrayList;
import java.util.TreeSet;

public class MaximumTripletSum {
    /*
    Approach:
        We need to traverse the array and for every element, get 2 numbers such that the sum becomes maximum:
            1. Maximum element on the left side, which is smaller than current element.
            2. Maximum element on right side, which is bigger than current element.

            For #1, we can leverage lower() method of TreeSet in Java,which returns a value strictly lesser than the given input. Time complexity: O(log n).
            For #2, we preprocess the input array and create another array called rMax. We traverse the input array from right side and insert maximum element found so far in this array.
            Searching the maximum element on the right side of a specific position will then become a constant time lookup in the rMax array.
     */

    public int solve(ArrayList<Integer> A) {
        int maxSum=Integer.MIN_VALUE, n=A.size();
        TreeSet<Integer> ts = new TreeSet<>();
        int rmax[] = new int[n]; //maximum element on the right for every element

        ts.add(A.get(0));
        rmax[n-1] = A.get(n-1);
        for(int i=n-2; i>=0; i--)
            rmax[i] = Math.max(rmax[i+1], A.get(i));

        for(int i=1; i< n-1; i++) {
            if(ts.lower(A.get(i)) != null && rmax[i+1] > A.get(i))
                maxSum = Math.max(maxSum, ts.lower(A.get(i)) + A.get(i) + rmax[i+1]);

            ts.add(A.get(i));
        }

        return maxSum;
    }
}
