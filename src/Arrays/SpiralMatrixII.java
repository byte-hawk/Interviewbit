/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.

Input Format:

The first and the only argument contains an integer, A.
Output Format:
Return a 2-d matrix of size A x A satisfying the spiral order.
Constraints:
1 <= A <= 1000
Examples:
Input 1:
    A = 3
Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]

Input 2:
    4
Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]
 */

package Arrays;

public class SpiralMatrixII {

    /**
     * Generate spiral matrix
     * @param A
     * @return
     */
    public int[][] generateMatrix(int A) {
        int matrix[][]= new int[A][A];
        int top = 0; int left = 0, bottom = A-1, right = A-1, cur = 1;

        while(cur <= A*A) {
            // traverse left to right in top most row
            for(int i=left; i<= right; i++)
                matrix[top][i] = cur++;

            top++;

            // traverse top to bottom in right most column
            for(int i=top; i<=bottom; i++)
                matrix[i][right] = cur++;

            right --;

            if(top>bottom)  break;

            // traverse right to left in bottom most row
            for(int i=right; i>=left; i--)
                matrix[bottom][i] = cur++;

            bottom--;

            if(left>right)  break;

            // traverse bottom to top in left most column
            for(int i=bottom; i>=top; i--)
                matrix[i][left] = cur++;

            left++;
        }

        return matrix;
    }
}
