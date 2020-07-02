/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Input Format
First and only argument is an integer array A.

Output Format
Return an integer denoting the maximum value of j - i;

Example Input
Input 1:
 A = [3, 5, 4, 2]
Example Output
Output 1:
 2
Example Explanation
Explanation 1:
 Maximum value occurs for pair (3, 4).
 */

package Arrays;

public class MaxDistance {

    /**
     * Find maximum of j-i such that A[i] <= A[j]
     * @param A
     * @return
     */
    public int maximumGap(final int[] A) {
        int n=A.length;
        int lMin[] = new int[n]; // Holds minimum value so far in left to right traversal
        int rMax[] = new int[n]; // Holds maximum value so far in right to left traversal

        lMin[0]=A[0];
        for(int i=1; i<n; i++)
            lMin[i] = Math.min(lMin[i-1], A[i]);

        rMax[n-1]=A[n-1];
        for(int i=n-2; i>=0; i--)
            rMax[i] = Math.max(rMax[i+1], A[i]);

        int i=0, j=0, maxDiff=0;
        while(i<n && j<n) {
            // Update maxDiff based on lMin & rMax
            if(lMin[i] <= rMax[j]) {
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            }
            else
                i++;
        }

        return maxDiff;
    }
}
