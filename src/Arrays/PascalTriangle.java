/*
Given numRows, generate the first numRows of Pascal’s triangle.
Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
Example:
Given numRows = 5,
Return
[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
 */

package Arrays;

import java.util.ArrayList;

public class PascalTriangle {

    /**
     * Create Pascal's triangle
     * @param A
     * @return
     */
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> pt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> prevRow = new ArrayList<Integer>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        int index=0;
        while(index < A){
            row = new ArrayList<Integer>();
            row.add(1); // add the left most 1
            if(index > 1){
                for(int i=1; i<index; i++){
                    row.add(prevRow.get(i-1) + prevRow.get(i));
                }
            }
            if(index != 0)  // add the right most 1
                row.add(1);

            pt.add(row);
            prevRow = (ArrayList) row.clone(); // Clone to avoid overriding issues
            index++;
        }

        return pt;
    }
}
