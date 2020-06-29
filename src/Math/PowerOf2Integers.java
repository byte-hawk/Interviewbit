/*
Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True
as 2^2 = 4.
 */

package Math;

public class PowerOf2Integers {

    /**
     * Calculate a^p
     * @param a
     * @param p
     * @return
     */
    private int pow(int a, int p) {
        int pow = 1;
        while(p>0) {
            if(p%2 == 1)
                pow = pow * a;

            p = p>>1;
            a = a * a;
        }

        return pow;
    }

    /**
     * Check, whether A can be expressed as A^P where P > 1 and A > 0
     * @param A
     * @return
     */
    public int isPower(int A) {
        if(A == 1)  return 1;
        int isPower = 0, limit = (int) Math.ceil(Math.log(A) / Math.log(2));
        for(int a = 2; isPower == 0 && a <= (int) Math.ceil(Math.sqrt(A)); a++) {
            for(int p = 2; isPower == 0 && p <= limit; p++) {
                if(pow(a , p) == A)
                    isPower = 1;
            }
        }

        return isPower;
    }
}
