/*
Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Example:

5 / 2 = 2
Also, consider if there can be overflow cases. For overflow case, return INT_MAX.

Note: INT_MAX = 2^31 - 1
 */

package Bitwise;

public class DivideIntegers {
    /*
        dividend = quotient * divisor + remainder
        Approach:
            Iterate for every bits of an integer from most significant position, i.e. from 31 to 0.
                a. Determine the most significant bit in the quotient.
                b. Find the 1st bit for which (divisor<<i) is smaller than dividend and update the ith bit position for which it is true.
                c. Add the result in temp variable for checking the next position such that (temp + (divisor << i) ) is less than dividend.
    */

    /**
     * Divide A by B
     * @param A
     * @param B
     * @return
     */
    public int divide(int A, int B) {

        // Minimum integer value is -2147483648, Maximum integer value is 2147483647
        // So, we need to handle this case of overflow separately
        if(A==Integer.MIN_VALUE && B==-1) return Integer.MAX_VALUE;

        // If a & b are of opposite sign, a XOR b will be a negative number
        int sign = (A ^ B)<0 ? -1 : 1;

        long ans = divideUtil(Math.abs((long)A), Math.abs((long)B));
        return (int)(sign*ans);
    }

    /**
     * Divide dividend by divisor, where both are positive number
     * @param dividend
     * @param divisor
     * @return
     */
    public long divideUtil(long dividend, long divisor){
        if(dividend < divisor) return 0; //As, we are looking for the quotient value only
        // Initialize the quotient
        long quotient = 0, temp = 0;

        // 1<<31 will overflow, thus 1L should be used for left shift
        for (int i = 31; i >= 0; --i) {
            if (temp + (divisor << i) <= dividend) {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }

        return quotient;
    }
}
