/*
Please Note:
There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

Food for thought :
Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3]
Output:[3, 4]

A = 3, B = 4
 */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {

    /*
        Approach :
            1. Take XOR of all elements with the natural number range 1 to n
            2. Now this will result in xor of the repeated & missing number.
            3. Take any set bit position in the XOR result and divide the numbers and do again step #1.
            4. Now we will get both repeated & missing number separately, but won't know which one is what
            5. SO, check whether any of them is present in the array or not to answer that
     */

    /**
     * Get the right most set bit position
     * @param n
     * @return
     */
    private static int getRightMostSetBitPos(int n)
    {
        return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1;
    }

    /**
     * Find the repeated & missing number
     * @param A
     * @return
     */
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int xor = 0;
        // do XOR of all numbers with natuaral numbers 1 to n
        for(int i=0; i<A.size(); i++)
            xor ^= (i+1) ^ A.get(i);

        int andValue = 1 << (getRightMostSetBitPos(xor)-1), zeroNum = 0, oneNum=0;
        // divide numbers based on set bit and xor them with natural number range
        for(int i=0; i<A.size(); i++) {
            if( (i+1 & andValue) > 0) {
                oneNum ^= (i+1);
            }
            else {
                zeroNum ^= (i+1);
            }

            if( (A.get(i) & andValue) > 0) {
                oneNum ^= A.get(i);
            }
            else {
                zeroNum ^= A.get(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        if(A.indexOf(zeroNum) == -1) {
            res.add(oneNum);
            res.add(zeroNum);
        }
        else {
            res.add(zeroNum);
            res.add(oneNum);
        }

        return res;
    }
}
