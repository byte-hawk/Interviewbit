/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note that if you end up using an additional array, you will only receive partial score.

Example:
If the array is
[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:
[
    [3, 1],
    [4, 2]
]
 */

package Arrays;

import java.util.ArrayList;

public class RotateMatrix {
    /*
        Approach:
            Swap these 4 elements in cyclic manner
                1. A[i][j]
                2. A[n-1-j][i]
                3. A[n-1-i][n-1-j]
                4. A[j][n-1-i]
     */

    /**
     * Clockwise rotate a nXn matrix by 90 degree
     * @param a
     */
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n=a.size();
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<Math.ceil(n/2.0); j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(n-1-j).get(i));
                a.get(n-1-j).set(i, a.get(n-1-i).get(n-1-j));
                a.get(n-1-i).set(n-1-j, a.get(j).get(n-1-i));
                a.get(j).set(n-1-i, temp);
            }
        }
    }
}
