/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:
[3 4 1 4 1]
Sample Output:
1

If there are multiple possible answers ( like in the sample case above ), output any one.
If there is no duplicate, output -1
 */

package Arrays;

import java.util.List;

public class FindDuplicateInArray {

    /* Approach:
        As all the numbers from range [1,n] are present and only one number appeared twice,
        we can dor XOR of all number in the range and all array elements to get the repeated number.
        As, then all numbers except the repeated number will appear twice and cancel out each other and
        the repeated number will appear thrice and 2 of them cancel out each other during XOR
     */

    /**
     * Find duplicate number in array of n+1 elements between 1 and n
     * @param A
     * @return
     */
    public int repeatedNumber(final List<Integer> A) {
        int repeated = 0;
        for(int i=0; i<A.size(); i++){
            repeated ^= A.get(i);
            if (i!= 0)  repeated ^= i;
        }
        return repeated;
    }
}
