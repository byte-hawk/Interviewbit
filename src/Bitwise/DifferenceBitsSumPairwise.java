/*
We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

For example,

A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) +
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8

*** This question is same as of pairwise hamming distance problem in the Math section.
 */

package Bitwise;

import java.util.List;

public class DifferenceBitsSumPairwise {

    /**
     * FInd sum of hamming distance of all pairs of an array
     * @param A
     * @return
     */
    public int cntBits(final List<Integer> A) {
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
