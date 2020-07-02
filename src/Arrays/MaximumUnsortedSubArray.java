/*
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :
Input 1:
A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:
A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.
 */

package Arrays;

import java.util.ArrayList;

public class MaximumUnsortedSubArray {
    /*
    Approach:
        1) Find the candidate sub-array
            a) Scan from left to right and find the first element which is greater than the next element. Let it be called s.
            b) Scan from right to left and find the first element which is smaller than the next element. Let it be called e.

        2) Verify & range rectification
            a) Find the minimum and maximum values in arr[s..e]. Let these values be min and max.
            b) Find the first element (if there is any) in arr[0..s-1] which is greater than min & change s to index of that element.
            c) Find the last element (if there is any) in arr[e+1..n-1] which is smaller than max, change e to index of that element.
     */

    /**
     * Find maximum length unsorted sub-array, sorting which makes the whole array sorted
     * @param A
     * @return
     */
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int n=A.size(), start=0, end=A.size()-1, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        // Determine start of range
        for(start=0; start<n-1; start++)
            if(A.get(start) > A.get(start+1))
                break;

        // If all are in sorted order
        if(start==n-1){
            result.add(-1);
            return result;
        }

        // Determine end of range
        for(end=n-1; end>0; end--)
            if(A.get(end) < A.get(end-1))
                break;

        for(int i=start; i<=end; i++) {
            min=Math.min(min, A.get(i));
            max=Math.max(max, A.get(i));
        }

        // Update start if required
        for(int i=0; i<start; i++) {
            if(A.get(i) > min){
                start=i;
                break;
            }
        }

        // Update end if required
        for(int i=n-1; i>end; i--) {
            if(A.get(i) < max) {
                end=i;
                break;
            }
        }

        result.add(start);
        result.add(end);
        return result;
    }
}
