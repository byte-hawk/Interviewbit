/*
Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.
For example,

HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
Return the answer modulo 1000000007.

Example:
Let f(x, y) be the hamming distance defined above.
A=[2, 4, 6]

We return,
f(2, 2) + f(2, 4) + f(2, 6) +
f(4, 2) + f(4, 4) + f(4, 6) +
f(6, 2) + f(6, 4) + f(6, 6) =

0 + 2 + 1
2 + 0 + 1
1 + 1 + 0 = 8
 */

package Math;

import java.util.List;

public class PairwiseHammingDistance {

    public int hammingDistance(final List<Integer> A) {
        int M = 1000000007;
        long hd = 0, n = A.size(), count;

        // Integer is of size 32 bit
        for(int b = 0; b < 32; b++) {
            count = 0;
            for(int i = 0; i < n; i++) {
                // If the bit differs
                if((A.get(i) & (1 << b)) > 0)
                    count++;

            }

            // Multiple n & (n-count) with 2, as we will get the same pair as both (i,j) & (j,i)
            hd = (hd % M + (2 * ((count * (n-count)) % M)) % M) % M;
        }

        return (int) (hd % M);
    }
}
