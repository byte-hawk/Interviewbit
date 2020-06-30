/*
Problem Description
Reverse the bits of an 32 bit unsigned integer A.

Problem Constraints
0 <= A <= 232

Input Format
First and only argument of input contains an integer A.

Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.

Example Input
Input 1:
 0
Input 2:
 3

Example Output
Output 1:
 0
Output 2:
 3221225472

Example Explanation
Explanation 1:

        00000000000000000000000000000000

=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011
=>      11000000000000000000000000000000
 */
package Bitwise;

public class ReverseBits {

    /**
     * Reverse bits of integer number
     * @param a
     * @return
     */
    public long reverse(long a) {
        // here, the input is given in long format for handling integer overflow scenarios
        long reverse = 0;

        // As integer is of 32 bits, so, the loop should run 32 times: 1 for each bit
        for (int i=0; i<32; i++) {
            reverse = (reverse << 1) + (a % 2);
            // left shift a, so that, the next bit can be retrieved
            a = a >> 1;
        }

        return reverse;
    }
}
