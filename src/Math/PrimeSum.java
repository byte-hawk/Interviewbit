/*
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE: A solution will always exist. read Goldbach’s conjecture[https://en.wikipedia.org/wiki/Goldbach%27s_conjecture]

Example:

Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then
[a, b] < [c, d]
If a < c OR a==c AND b < d.
 */

package Math;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSum {

    private boolean[] getPrimeSieve(int num) {
        boolean primeSieve[] = new boolean[num+1];
        // Initialize sieve array with true
        Arrays.fill(primeSieve, true);

        // 1 is not a prime number
        primeSieve[1] = false;
        for(int i = 2; i <= num; i++) {
            for(int j = 2; i * j <= num; j++) {
                primeSieve[i * j]= false;
            }
        }

        return primeSieve;
    }

    public ArrayList<Integer> primeSum(int A) {
        boolean found = false;
        boolean primeSieve[] = getPrimeSieve(A);
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; found == false && i < A - 1; i++) {
            if(primeSieve[i]) {
                for(int j = i; found == false && i + j <= A; j++) {
                    if(primeSieve[j] && i + j == A){
                        primes.add(i);
                        primes.add(j);
                        found = true;
                    }
                }
            }
        }

        return primes;
    }
}
