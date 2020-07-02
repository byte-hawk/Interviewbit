/*
Find the contiguous subarray within an array, A of length N which has the largest sum.

Input Format:
The first and the only argument contains an integer array, A.
Output Format:
Return an integer representing the maximum possible sum of the contiguous subarray.
Constraints:
1 <= N <= 1e6
-1000 <= A[i] <= 1000
For example:
Input 1:
    A = [1, 2, 3, 4, -10]
Output 1:
    10
Explanation 1:
    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
Input 2:
    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output 2:
    6
Explanation 2:
    The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
package Arrays;

import java.util.List;

public class MaxSumContinuousSubArray {
    /*
    Approach: Kadane's algorithm
     */

    /**
     * Get maximum sum of continuous sub-array
     * @param A
     * @return
     */
    public int maxSubArray(final List<Integer> A) {
        int max = Integer.MIN_VALUE, localMax = 0, globalMax = 0;

        for(int item : A){
            localMax += item;
            max = Math.max(max, item);
            globalMax = Math.max(globalMax, localMax);

            // update local maximum sum to zero, if the sum has become negative
            localMax = Math.max(localMax, 0);
        }

        // Kadane's algorithm doesn't work for cases, when the contains only negative numbers
        // thus this case need to be handled specially
        return (max < 0) ? max : globalMax;
    }
}
