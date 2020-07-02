/*
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
Input Format:
The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:
Return a 2-d matrix that satisfies the given conditions.
Constraints:
1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 1, 1]   ]
Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]
Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
 */

package Arrays;

import java.util.ArrayList;

public class SetMatrixZeros {

    /*
    Approach:
        Create 2 flag arrays: one for rows & another for columns to indicate that particular row or column should be set to zero or not
        But doing so will need extra memory.
        Take 2 variable r & c for setting the flag of row 1 & column 1.
        Now, reset row 1 & column 1 and use them as flag arrays required.
     */

    /**
     * Set matrix row & column to 0 if the element at that position is 0
     * @param a
     */
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean firstRow = false, firstCol = false;

        // Calculate first column flag
        for (int i=0;i<a.size();i++) {
            if (a.get(i).get(0) == 0) {
                firstCol = true;
                break;
            }
        }

        // Calculate first row flag
        for (int i=0;i<a.get(0).size();i++) {
            if (a.get(0).get(i) == 0) {
                firstRow = true;
                break;
            }
        }

        // Reset first row & column
        for (int i=0;i<a.size();i++) {
            for (int j=0;j<a.get(0).size();j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }

        // Fill-up the flag arrays
        for(int i=1; i<a.size(); i++){
            for(int j=1; j<a.get(i).size(); j++){
                if(a.get(i).get(0) == 0 || a.get(0).get(j) == 0){
                    a.get(i).set(j, 0);
                }
            }
        }

        // Update first column based on the flag
        if(firstCol){
            for(int i=0; i<a.size(); i++)
                a.get(i).set(0,0);
        }

        // Update first row based on the flag
        if(firstRow){
            for(int i=0; i<a.get(0).size(); i++)
                a.get(0).set(i, 0);
        }

    }
}
