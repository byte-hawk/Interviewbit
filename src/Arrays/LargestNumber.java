/*
Given a list of non negative integers, arrange them such that they form the largest number.
For example:
Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
 */

package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    /**
     * Get largest number by arranging the array elements
     * @param A
     * @return
     */
    public String largestNumber(final List<Integer> A) {
        List<String> arr = new ArrayList<>();
        for(int i: A)
            arr.add(String.valueOf(i));

        // Sort the numbers such a way that by combining them, we can get the largest number
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        StringBuilder sb=new StringBuilder();
        for(String s: arr)
            sb.append(s);

        //remove the extra zeros at the begining
        while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
