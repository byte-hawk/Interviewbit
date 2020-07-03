/*
Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Input Format:

    First and only argument of input contains an integer array A
Output Format:

    return a single integer.
Constraints:

2 <= N <= 5 000 000
0 <= A[i] <= INT_MAX
For Examples :

Example Input 1:
    A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Example Output 1:
    4
Explanation:
    4 occur exactly once
Example Input 2:
    A = [0, 0, 0, 1]
Example Output 2:
    1
 */
package Bitwise;

import java.util.List;

public class SingleNumberII {
    /*
    Approach :
        For each of 32 bit(As integer is of 32 bits) positions, take count of numbers in the array, for which that bit is set.
        If the count is not divisible by 3,
        then that bit is set for the single number.
     */

    /**
     * Get the number occuring only once while other numbers appear exactly thrice
     * @param A
     * @return
     */
    public int singleNumber(final List<Integer> A) {
        int single = 0;

        for(int i=0;i<32;i++){
            int count = 0;
            for(int j=0;j<A.size();j++){
                if(((A.get(j)>>i)&1) == 1)
                    count++;
            }
            if(count%3 != 0)
                single = single | (1<<i);
        }
        return single;
    }
}
