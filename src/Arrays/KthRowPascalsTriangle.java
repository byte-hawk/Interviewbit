/*
Given an index k, return the kth row of the Pascal’s triangle.
Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:
Input : k = 3
Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].
Note:Could you optimize your algorithm to use only O(k) extra space?
 */

package Arrays;

import java.util.ArrayList;

public class KthRowPascalsTriangle {

    /**
     * Get Kth row of Pascal's triangle
     * @param A
     * @return
     */
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> prevRow = new ArrayList<Integer>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        int index=0;
        while(index <= A){
            row = new ArrayList<Integer>();
            row.add(1);// add the left most 1

            if(index > 1){
                for(int i=1; i<index; i++){
                    row.add(prevRow.get(i-1) + prevRow.get(i));
                }
            }
            if(index != 0)  // add the right most 1
                row.add(1);

            prevRow = (ArrayList)row.clone(); // Clone to avoid overriding issues
            index++;
        }

        return row;
    }
}
