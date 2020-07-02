/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:
Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,
S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].
 */

package Arrays;

import java.util.ArrayList;

public class Flip {

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> range = new ArrayList<>();
        if(A == null || A.length() == 0 || A.indexOf('0') == -1)    return range;
        int n=A.length(), start=-1, end=-1, curStart=0, maxDiff=0, zeroCount=0, oneCount=0;

        for(int i=0; i<A.length(); i++) {
            if(A.charAt(i) == '0')  zeroCount++;
            else  oneCount++;

            // If there are more zeros than one and the difference is highest so far
            if(zeroCount-oneCount > maxDiff){
                start=curStart;
                end=i;
                maxDiff = zeroCount-oneCount;
            }
            else if(zeroCount < oneCount) {
                zeroCount=0;
                oneCount=0;
                curStart=i;
            }
        }

        //skip the initial ones of the selected range
        while(start<A.length()) {
            if(A.charAt(start) == '1') start++;
            else    break;
        }

        range.add(start+1);
        range.add(end+1);

        return range;
    }
}
