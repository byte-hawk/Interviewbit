/*
Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
Return 1 for true or 0 for false.

Example:
Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1
as
0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.
O(n) solution is expected.

Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
 */

package Arrays;

import java.util.ArrayList;

public class TripletSumGivenRange {

    public boolean isInFirst(Double d) {
        return ((d > 0) && (d < 2.0/3.0));
    }

    public boolean isInSecond(Double d) {
        return ((d >= 2.0/3.0) && (d< 1.0));
    }

    public boolean isInThird(Double d) {
        return ((d >= 1.0) && (d < 2.0));
    }

    public int solve(ArrayList<String> A) {

        if(A.size() < 3) {
            return 0;
        }

        ArrayList<Double> num = new ArrayList<Double>();
        for(Integer i = 0; i < A.size(); i++) {
            num.add(Double.valueOf(A.get(i)));
        }

        Double max1A = -1.0f*Double.MAX_VALUE, max2A = -1.0f*Double.MAX_VALUE, max3A = -1.0f*Double.MAX_VALUE, max1B = -1.0f*Double.MAX_VALUE;
        Double min1A = Double.MAX_VALUE, min2A = Double.MAX_VALUE, min1B = Double.MAX_VALUE, min2B = Double.MAX_VALUE, min1C = Double.MAX_VALUE;

        for(Integer i = 0; i < num.size(); i++) {
            if(max1A < num.get(i) && isInFirst(num.get(i))) {
                max3A = max2A;
                max2A = max1A;
                max1A = num.get(i);
            } else if(max2A < num.get(i) && isInFirst(num.get(i))) {
                max3A = max2A;
                max2A = num.get(i);
            } else if(max3A < num.get(i) && isInFirst(num.get(i))) {
                max3A = num.get(i);
            } else if(max1B < num.get(i) && isInSecond(num.get(i))) {
                max1B = num.get(i);
            }

            if(min1A > num.get(i) && isInFirst(num.get(i))) {
                min2A = min1A;
                min1A = num.get(i);
            } else if(min2A > num.get(i) && isInFirst(num.get(i))) {
                min2A = num.get(i);
            } else if(min1B > num.get(i) && isInSecond(num.get(i))) {
                min2B = min1B;
                min1B = num.get(i);
            } else if(min2B > num.get(i) && isInSecond(num.get(i))) {
                min2B = num.get(i);
            } else if(min1C > num.get(i) && isInThird(num.get(i))) {
                min1C = num.get(i);
            }
        }

        if(max1A+max2A+max3A > 1.0) {
            return 1;
        } else if((max1A+max2A+max1B > 1.0) && (max1A+max2A+max1B < 2.0)) {
            return 1;
        } else if((min1A+min2A+min1B > 1.0) && (min1A+min2A+min1B < 2.0)) {
            return 1;
        } else if(min1A+min2A+min1C < 2.0) {
            return 1;
        } else if(min1A+min1B+min2B < 2.0) {
            return 1;
        } else if(min1A+min1B+min1C < 2.0) {
            return 1;
        }

        return 0;
    }
}
