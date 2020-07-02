/*
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
Example:
Input:
1 2 3
4 5 6
7 8 9
Return the following :
[
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]

Input :
1 2
3 4
Return the following  :
[
  [1],
  [2, 3],
  [4]
]
 */

package Arrays;

import java.util.ArrayList;

public class AntiDiagonal {

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int n=A.size(), si=0, sj=0, ci=0, cj=0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        while(si+sj < 2*n-1){ // 2*n-1 is the maximum row size possible
            ci=si;
            cj=sj;
            ArrayList<Integer> row = new ArrayList<>();

            while(ci<n && cj>=0){
                row.add(A.get(ci).get(cj));
                ci++;
                cj--;
            }
            res.add(row);

            sj++;
            if(sj == n){
                sj = n-1;
                si++;
            }
        }
        return res;
    }
}
