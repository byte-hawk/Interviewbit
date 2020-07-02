/*
Given an array of integers, sort the array into a wave like array and return it,
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
So, in example case, you will return [2, 1, 4, 3]
 */

package Arrays;

public class WaveArray {
    /*
        Approach:
            Sort the array & swap consecutive elements in pairs
     */

    /**
     * Swap 2 elements of an array
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Create a wave array
     * @param A
     * @return
     */
    public int[] wave(int[] A) {
        java.util.Arrays.sort(A);
        for(int i=0; i<A.length-1; i+=2)
            swap(A, i+1, i);

        return A;
    }
}
