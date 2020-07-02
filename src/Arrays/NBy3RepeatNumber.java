/*
You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.

Example :
Input : [1 2 3 1 1]
Output : 1
1 occurs 3 times which is more than 5/3 times.
 */

package Arrays;

import java.util.List;

public class NBy3RepeatNumber {
    /*
    Approach:
        This is a modified version od Moore's voting algorithm(Method 3 in https://www.geeksforgeeks.org/majority-element/).
        Here instead of 1 candidate, we check with 2 candidate variable.
     */

    /**
     * find the number repeating n/3 or more times
     * @param a
     * @return
     */
    public int repeatedNumber(final List<Integer> a) {
        int n=a.size(), first=Integer.MIN_VALUE, second=Integer.MIN_VALUE, countFirst=0, countSecond=0;

        // Get possible first & second candidate
        for(int i=0; i<n; i++){
            if(first==a.get(i)) countFirst++;
            else if(second==a.get(i)) countSecond++;
            else if(countFirst==0) {
                first=a.get(i);
                countFirst++;
            }
            else if(countSecond==0) {
                second=a.get(i);
                countSecond++;
            }
            else{
                countFirst--;
                countSecond--;
            }
        }

        // verify first & second candidate
        countFirst=0; countSecond=0;
        for(int i=0; i<n; i++){
            if(first==a.get(i)) countFirst++;
            else if(second==a.get(i))    countSecond++;
        }

        if(countFirst>n/3)  return first;
        else if(countSecond>n/3) return second;
        else return -1;
    }
}
