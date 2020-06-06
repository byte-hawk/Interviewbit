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

package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfLengthNLessK {
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

    public int solve(ArrayList<Integer> A, int n, int k) {
        List<Integer> kDigits = numToList(k);
        int d = A.size();
        if (kDigits.size() < n || d == 0) return 0;

        if (kDigits.size() > n) {
            if (A.get(0) == 0 & n != 1)
                return (d - 1) * (int) Math.pow(d, n - 1);
            else
                return (int) Math.pow(d, n);
        } else {
            int count = 0;

            int mul = (int) Math.pow(d, n);
            int lower[] = new int[11];

            for (int i = 0; i < d; i++)
                lower[A.get(i) + 1] = 1;
            for (int i = 1; i <= 10; i++)
                lower[i] = lower[i - 1] + lower[i];

            for (int i = 0; i < kDigits.size(); i++) {
                mul /= d;
                int d2 = lower[kDigits.get(i)];
                if (i == 0 && A.get(0) == 0 && n != 1) d2--;
                count += d2 * mul;
                if (A.indexOf(kDigits.get(i)) == -1) break;
            }

            return count;
        }
    }
}
