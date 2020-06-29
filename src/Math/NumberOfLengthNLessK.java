/*
Numbers of length N and value less than K

Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set.
Examples:

	Input:
	  0 1 5
	  1
	  2
	Output:
	  2 (0 and 1 are possible)

	Input:
	  0 1 2 5
	  2
	  21
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
Constraints:

    1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9
 */

/*
Approach: We can break this problem into 3 cases:
I - N>length(K) :
    No such number possible.

II - N<length(K) :
    All combination of digits of length N are valid, except 0 can't be in the beginning.
    As repetition is allowed, 0 can be placed at d-1 places and every other digits can be placed at d places.
    So, answer is (d–1)*(d^N – 1) if A[] contains 0 else d^N.

II - N=length(K) :
    We need to use Dynamic Programming to count the numbers.

    Sample Input: A = [0, 1, 2, 5],   N=3,    k=231
    lower[2] = 2, but we can't put 0 in the first spot => (2-1) X 4 X 4
    lower[3] = 3                                       => 3 X 4
    As, 3 is not present in A, we stop here.
 */
package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfLengthNLessK {

    /**
     * Collect the digits of the number in a list
     * @param num
     * @return
     */
    private List<Integer> numToList(int num){
        ArrayList<Integer> digits = new ArrayList<Integer>();
        if(num == 0)    digits.add(0);
        while(num > 0){
            digits.add(num%10);
            num /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    /**
     * Get total count of numbers of length N and value less than K
     * @param A
     * @param n
     * @param k
     * @return
     */
    public int solve(ArrayList<Integer> A, int n, int k) {
        List<Integer> kDigits = numToList(k);
        int d = A.size();

        // CASE I
        if (kDigits.size() < n || d == 0) return 0;

        // CASE II
        if (kDigits.size() > n) {
            if (A.get(0) == 0 & n != 1)
                return (d - 1) * (int) Math.pow(d, n - 1);
            else
                return (int) Math.pow(d, n);
        }
        else { // CASE III
            int count = 0, multiplier = (int) Math.pow(d, n);

            // lower[i] denote the number of elements in A[] which are smaller than i.
            int lower[] = new int[11];

            for (int i = 0; i < d; i++)
                lower[A.get(i) + 1] = 1;
            for (int i = 1; i <= 10; i++)
                lower[i] = lower[i - 1] + lower[i];

            for (int i = 0; i < kDigits.size(); i++) {
                multiplier /= d;
                int d2 = lower[kDigits.get(i)];
                if (i == 0 && A.get(0) == 0 && n != 1) d2--;
                count += d2 * multiplier;
                if (A.indexOf(kDigits.get(i)) == -1) break;
            }

            return count;
        }
    }
}
