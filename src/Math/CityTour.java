/*
There are A cities numbered from 1 to A. You have already visited M cities, the indices of which are given in an array B of M integers.

If a city with index i is visited, you can visit either the city with index i-1 (i >= 2) or the city with index i+1 (i < A) if they are not already visited.
Eg: if N = 5 and array M consists of [3, 4], then in the first level of moves, you can either visit 2 or 5.

You keep visiting cities in this fashion until all the cities are not visited.
Find the number of ways in which you can visit all the cities modulo 10^9+7.

Input Format

The 1st argument given is an integer A, i.e total number of cities.
The 2nd argument given is an integer array B, where B[i] denotes ith city you already visited.
Output Format

Return an Integer X % (1e9 + 7), number of ways in which you can visit all the cities.
Constraints

1 <= A <= 1000
1 <= M <= A
1 <= B[i] <= A
For Example

Input:
    A = 5
    B = [2, 5]
Output:
    6

Explanation:
    All possible ways to visit remaining cities are :
    1. 1 -> 3 -> 4
    2. 1 -> 4 -> 3
    3. 3 -> 1 -> 4
    4. 3 -> 4 -> 1
    5. 4 -> 1 -> 3
    6. 4 -> 3 -> 1
 */

package Math;

import java.util.ArrayList;
import java.util.Collections;

public class CityTour {

    /**
     * Calculate number of city tours possible
     * @param A
     * @param B
     * @return
     */
    public int solve(int A, ArrayList<Integer> B) {

        // Sort the cities in ascending order
        Collections.sort(B);

        // Let’s say the visited cities are (a1, a2, a3,...ak) and all cities be (1,2,...n).
        // So, the cities get divided into k+1 segments (1 to a1-1 , a1+1 to a2-1,...ak+1 to n)

        long comb[][] = new long[1001][1001];
        long exp[] = new long[1001];
        int M = 1000000007,
                count = B.get(0)-1,         // width of the first segment of unvisited cities
                last = A-B.get(B.size()-1), // width of the last segment of unvisited cities
                cur;                       // width of the current segment of unvisited cities
        long ans = 1;

        // Populate nCk mod M matrix
        for(int i = 0; i < 1001; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || i == j)
                    comb[i][j] = 1; //Value of nC0 & nCn are 1
                else
                    comb[i][j] = (comb[i-1][j] + comb[i-1][j-1])% M;    //For other cases nCk = (n-1)Ck + (n-1)C(k-1)
            }
        }

        // Populate power of 2 series with mod M
        exp[0] = 1;
        for(int i = 1; i < 1001; i++)
            exp[i] = (exp[i-1]*2) % M;

        for(int i = 1; i < B.size(); i++){
            cur = B.get(i)-B.get(i-1)-1; // Get width of the current segment of unvisited cities
            if(cur > 0){
                // There are 2^l-1 ways of visiting cities between 2 visited cities,
                // where l is the segment length
                ans = ((ans*exp[cur-1])%M * comb[count+cur][cur])%M;
                count += cur; // total number of unvisited cities so far
            }
        }

        ans = (ans * comb[count+last][last])%M; // consider the last segment of unvisited cities
        return (int)ans;
    }
}
