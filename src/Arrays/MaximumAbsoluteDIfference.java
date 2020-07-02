/*
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,
A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
 */

package Arrays;

public class MaximumAbsoluteDIfference {
    /*
    Approach:
        f(i, j) = |A[i] – A[j]| + |i – j| can be written in 4 ways

        Case 1: A[i] > A[j] & i > j
        |A[i] - A[j]| = A[i] - A[j]
        |i -j| = i - j
        So, f(i, j) = (A[i] + i) - (A[j] + j)

        Case 2: A[i] > A[j] and i < j
        |A[i] - A[j]| = A[i] - A[j]
        |i -j| = -i + j
        So, f(i, j) = (A[i] - i) - (A[j] - j)

        Case 3: A[i] < A[j] & i < j
        |A[i] - A[j]| = -A[i] + A[j]
        |i -j| = -i + j
        So, f(i, j) = -(A[i] + i) + (A[j] + j)

        Case 4: A[i] < A[j] and i > j
        |A[i] - A[j]| = -A[i] + A[j]
        |i -j| = i - j
        So, f(i, j) = -(A[i] - i) + (A[j] - j)

        Algorithm:
        1. Calculate the value of A[i]+i and A[i]–i for every element of the array while traversing.
        2. Store minimum and maximum values of expressions A[i]+i and A[i]–i for all i.
        3. Hence the required maximum absolute difference is maximum of two values i.e. max( (A[i]+i) – (A[j]+j) ) and max( (A[i]–i) – (A[j]–j) ).
    */

    /**
     * Find maximum absolute difference in an array
     * @param A
     * @return
     */
    public int maxArr(int[] A) {
        int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            max1 = Math.max(max1, (A[i]+i));
            max2 = Math.max(max2, (A[i]-i));
            min1 = Math.min(min1, (A[i]+i));
            min2 = Math.min(min2, (A[i]-i));
        }

        return Math.max(max1-min1, max2-min2);
    }
}
