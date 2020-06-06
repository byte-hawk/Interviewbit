/*
Grid Unique Paths

A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
              OR  : (0, 0) -> (1, 0) -> (1, 1)
 */

package Math;

public class GridUniquePaths {

    public int uniquePaths(int A, int B) {
        int dp[][] = new int[A][B];

        // There is only 1 way if there is single column
        for(int i=0; i<A; i++)
            dp[i][0] = 1;

        // There is only 1 way if there is single row
        for(int i=0; i<B; i++)
            dp[0][i] = 1;

        // At any instance, if we are on (x, y), we can either go to (x, y + 1) or (x + 1, y).
        for(int i=1; i<A; i++)
            for(int j=1; j<B; j++)
                dp[i][j] = dp[i-1][j]+dp[i][j-1];

        return dp[A-1][B-1];
    }
}
