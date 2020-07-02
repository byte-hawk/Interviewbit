/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
 */

package Arrays;

public class MaximumConsectiveGap {

    public class Bucket{
        int low;
        int high;
        public Bucket(){
            low = -1;
            high = -1;
        }
    }

    public int maximumGap(final int[] A) {
        if(A == null || A.length < 2)   return 0;
        int max = A[0], min = A[0], n=A.length;
        for(int i=1; i<n; i++){
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        // initialize buckets
        Bucket[] buckets = new Bucket[n+1];
        for(int i=0; i<n+1; i++){
            buckets[i] = new Bucket();
        }

        double interval = (double) n / (max - min);
        //distribute every number to a bucket array
        for(int i=0; i<n; i++){
            int index = (int) ((A[i] - min) * interval);
            if(buckets[index].low == -1){
                buckets[index].low = A[i];
                buckets[index].high = A[i];
            }else{
                buckets[index].low = Math.min(buckets[index].low, A[i]);
                buckets[index].high = Math.max(buckets[index].high, A[i]);
            }
        }

        //scan buckets to find maximum gap
        int maxGap = 0;
        int prev = buckets[0].high;
        for(int i=1; i<n+1; i++){
            if(buckets[i].low != -1){
                maxGap = Math.max(maxGap, buckets[i].low-prev);
                prev = buckets[i].high;
            }
        }

        return maxGap;
    }
}
