/*
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Input Format:

    First and only argument of input contains an integer array A
Output Format:

    return a single integer denoting minimum xor value
Constraints:

2 <= N <= 100 000
0 <= A[i] <= 1 000 000 000
For Examples :

Example Input 1:
    A = [0, 2, 5, 7]
Example Output 1:
    2
Explanation:
    0 xor 2 = 2
Example Input 2:
    A = [0, 4, 7, 9]
Example Output 2:
    3
 */
package Bitwise;

import java.util.ArrayList;
import java.util.Collections;

public class MinXORValue {

    /**
     * Get minimum XOR value of any pair from a list of integers
     * @param A
     * @return
     */
    public int findMinXor(ArrayList<Integer> A) {
        // minimum XOR is possible for only in case on consecutive numbers in sorted order
        Collections.sort(A);
        int minXOR = Integer.MAX_VALUE;
        for(int i=1; i<A.size(); i++)
            minXOR = Math.min(minXOR, A.get(i-1)^A.get(i));

        return minXOR;
    }
}
