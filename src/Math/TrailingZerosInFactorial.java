/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120
Number of trailing zeros = 1
So, return 1
 */

/*
Approach:
The idea is to check for the prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5.
If we can count the number of 5s and 2s, our task is done. The number of 2s in prime factors is always more than or equal to the number of 5s.
So we just need to count 5s in prime factors.

How to count total number of 5s in n!?
A simple way is to calculate floor(n/5), but numbers like 25, 125 has more than one 5.

Formula:
Trailing 0s in n! = Count of 5s in prime factors of n!
                  = floor(n/5) + floor(n/25) + floor(n/125) + ....
 */

package Math;

public class TrailingZerosInFactorial {

    public int trailingZeroes(int A) {

        int trailingZeros = 0;
        for(int i = 5; i <= A; i *= 5)
            trailingZeros += A / i;


        return trailingZeros;
    }
}
