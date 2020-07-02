/*
Given an unsorted integer array, find the first missing positive integer.

Example:
Given [1,2,0] return 3,
[3,4,-1,1] return 2,
[-8, -7, -6] returns 1
Your algorithm should run in O(n) time and use constant space.
 */

package Arrays;

public class FirstMissingInteger {

    /**
     * Find first missing integers in an unsorted array
     * @param A
     * @return
     */
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            // when the ith element is not equals to i+1
            while (A[i] != i+1) {
                // no need to swap when ith element is out of range
                if (A[i] <= 0 || A[i] >= n)
                    break;

                //handle duplicate elements
                if(A[i]==A[A[i]-1])   break;

                // swap A[i] && A[A[i]]
                int temp = A[i];
                A[i] = A[temp-1];
                A[temp-1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != i+1)
                return i+1;
        }

        return n+1;
    }
}
