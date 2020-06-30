/*
Given a string, find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' :
abc
acb
bac
bca
cab
cba

The answer might not fit in an integer, so return your answer % 1000003
 */

package Math;

public class SortedPermutationRank {
    /*
    Approach:
        Lets consider the input as "STRING"
        At first, we need to calculate the count of smaller characters on the right for every character.
        Input =>  S T R I N G
        Counts => 4 4 3 1 1 0
        S has 4 smaller characters on right: R,I,N,G; So there can be 4 * 5! smaller strings where first character is smaller than 'S'.
        Similarly, we can calculate count of smaller characters and their contribution for other characters.

        So rank of the current string will be= 4X5! + 4X4! + 3X3! + 1X2! + 1X1! + 0X0!
     */

    private static int M=1000003;

    /**
     * Count the number of smaller characters on right side
     * @param a
     * @param pos
     * @return
     */
    private int findSmallerInRight(String a, int pos) {
        int rank = 0;
        for (int i = pos+1; i < a.length(); i++)
            if (a.charAt(i) < a.charAt(pos))
                rank++;

        return rank;
    }

    /**
     * Calculate factorial of n mod M
     * @param n
     * @return
     */
    public int factorial(int n) {
        int prod = 1;
        for (int i = 1; i <= n; i++)
            prod = (prod * i)%M;

        return prod;
    }

    /**
     * Find the lexicographic rank of a string without duplicate characters
     * @param a
     * @param start
     * @return
     */
    public int findRank(String a, int start) {
        if (start == a.length()-1)    return 1;
        int countRight = findSmallerInRight(a, start);
        int rank = (countRight * factorial(a.length()-start-1)) % M;
        return (rank + findRank(a, start+1)) % M;
    }

    /**
     * Find the lexicographic rank of a string without duplicate characters
     * @param a
     * @return
     */
    public int findRank(String a) {
        return findRank(a, 0);
    }
}
