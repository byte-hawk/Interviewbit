/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.

Note:
1. The replacement must be in-place, do **not** allocate extra memory.
2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
Input Format:
The first and the only argument of input has an array of integers, A.
Output Format:
Return an array of integers, representing the next permutation of the given array.
Constraints:
1 <= N <= 5e5
1 <= A[i] <= 1e9
Examples:
Input 1:
    A = [1, 2, 3]
Output 1:
    [1, 3, 2]

Input 2:
    A = [3, 2, 1]
Output 2:
    [1, 2, 3]

Input 3:
    A = [1, 1, 5]
Output 3:
    [1, 5, 1]

Input 4:
    A = [20, 50, 113]
Output 4:
    [20, 113, 50]
 */

package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {

    /**
     * Permute the numbers to create next bigger number combining all numbers in order
     * @param A
     * @return
     */
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size(), k = -1, l = 0;
        for (int i=0; i<n-1; i++)
            if (A.get(i) < A.get(i+1))
                k = i;

        if (k == -1) {
            Collections.sort(A);
            return A;
        }

        for (int i=k+1; i<n;i++)
            if (A.get(i) > A.get(k))
                l = i;

        int temp = A.get(l);
        A.set(l, A.get(k));
        A.set(k, temp);

        int j = k + 1, last = n-1;
        while(j <= last){
            temp = A.get(j);
            A.set(j, A.get(last));
            A.set(last, temp);
            j++;
            last--;
        }
        return A;
    }
}
