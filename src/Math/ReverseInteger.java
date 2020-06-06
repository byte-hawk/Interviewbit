/*
Reverse digits of an integer.

Example1:
x = 123,
return 321

Example2:
x = -123,
return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */

package Math;

public class ReverseInteger {

    public int reverse(int A) {

        int sign = A / Math.abs(A);
        long rev = 0;
        A = Math.abs(A);

        while(A>0) {
            rev = (rev * 10) + A % 10;

            // If there's an overflow
            if(rev > Integer.MAX_VALUE) {
                rev = 0;
                break;
            }

            A/=10;
        }

        return (int) (rev*sign);
    }
}
