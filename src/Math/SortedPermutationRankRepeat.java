/*
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.
Look at the example for more details.

Example :

Input : 'aba'
Output : 2

The order permutations with letters 'a', 'a', and 'b' :
aab
aba
baa
The answer might not fit in an integer, so return your answer % 1000003

NOTE: 1000003 is a prime number
NOTE: Assume the number of characters in string < 1000003
 */

/*
Approach:
Sample Input: "settle"
Algorithm:
Character | Smaller char on right  |  Repeated char on right |  Permutations
                                        (including current)

    s         3(e,l,e)                  2e, 2t                  (3X5!)/(2!X2!)
    e         0                         2e, 2t                  (0X4!)/(2!X2!)
    t         2(l,e)                    2t                      (2X3!)/(2!)
    t         2(l,e)                      -                     (2X2!)/(0!)
    L         1(e)                        -                     (1X1!)/(0!)
    e         0                           -                     (0X0!)/(0!)

Rank of the string: (3X5!)/(2!X2!) + (0X4!)/(2!X2!) + (2X3!)/(2!) + (2X2!)/(0!) + (1X1!)/(0!) + (0X0!)/(0!)
 */

package Math;
import java.util.*;
import java.math.*;

public class SortedPermutationRankRepeat {

    private static final int M = 1000003;

    /**
     * Count the number of smaller characters on right side of pos
     * @param a
     * @param pos
     * @return
     */
    private static int findSmallerInRight(String a, int pos) {
        int count = 0;
        for (int i = pos+1; i < a.length(); i++)
            if (a.charAt(i) < a.charAt(pos))
                count++;

        return count;
    }

    /**
     * Find the occurrences of repeated characters on right side starting from pos
     * @param a
     * @param pos
     * @return
     */
    private static List<Integer> findRepeatations(String a, int pos) {
        List<Integer> repeatations = new ArrayList<>();
        Map<Character, Integer> charCounts = new HashMap<>();
        for(int i=pos; i<a.length(); i++) {
            char x = a.charAt(i);
            int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
            charCounts.put(x, xCount);
        }

        for(int i : charCounts.values())
            if(i>1) repeatations.add(i);

        return repeatations;
    }

    /**
     * Calculate factorial of n in BigInteger
     * @param n
     * @return
     */
    public static BigInteger factorial (int n) {

        BigInteger prod = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            prod = prod.multiply(BigInteger.valueOf(i));

        return prod;
    }

    /**
     * Find the lexicographic rank of a string with duplicate characters
     * @param a
     * @param low
     * @return
     */
    public static BigInteger findRank(String a, int low) {
        if (low == a.length()-1)    return BigInteger.ONE;
        int countRight = findSmallerInRight(a, low), n = a.length()-1;
        List<Integer> repeatations = findRepeatations(a, low);
        BigInteger rank = (BigInteger.valueOf(countRight)).multiply(factorial(n-low));
        for(int r : repeatations)
            rank = rank.divide(factorial(r));

        return rank.add(findRank(a, low+1));
    }

    /**
     * Find the lexicographic rank of a string with duplicate characters
     * @param a
     * @return
     */
    public static int findRank(String a) {
        BigInteger rank = findRank(a, 0);
        return rank.remainder(BigInteger.valueOf(M)).intValue();
    }
}
