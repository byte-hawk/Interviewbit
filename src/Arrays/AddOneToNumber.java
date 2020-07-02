/*
Given a non-negative number represented as an array of digits,
add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.
Example:

If the vector has [1, 2, 3]
the returned vector should be [1, 2, 4]
as 123 + 1 = 124.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
*/

package Arrays;

import java.util.ArrayList;

public class AddOneToNumber {

    /**
     * Add one to a given number represented by a list
     * @param A
     * @return
     */
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        if(A == null || A.size()== 0)   return A;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n=A.size(), sum = A.get(n-1)+1, carry=0;

        if(sum > 9) {
            carry = sum-9;
            sum %= 10;
        }
        A.set(n-1, sum);
        for(int i=n-2; i>=0; i--) {
            sum = A.get(i)+carry;
            if(sum > 9) {
                carry = sum-9;
                sum %= 10;
                A.set(i, sum);
            }
            else{
                carry = 0;
                A.set(i, sum);
                break;
            }
        }

        if(carry != 0)
            A.add(0, carry);

        int i;
        // Skip 0s in the beginning
        for(i=0; i<A.size(); i++){
            if(A.get(i)!=0){
                break;
            }
        }

        // Start copying from 1st non-zero digit
        for(int j=i; j<A.size(); j++)
            result.add(A.get(j));

        return result;
    }
}
