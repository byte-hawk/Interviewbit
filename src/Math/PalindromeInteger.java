/*
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
 */

package Math;

public class PalindromeInteger {

    private int getReverseNumber(int A){
        if(A == 0)  return 0;
        int reverse = 0;
        while(A > 0){
            reverse = (reverse * 10) + A % 10;
            A /= 10;
        }

        return reverse;
    }

    public int isPalindrome(int A) {
        return A == getReverseNumber(A) ? 1 : 0;
    }
}
