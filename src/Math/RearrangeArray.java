/*
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
 */
package Math;

import java.util.ArrayList;

public class RearrangeArray {

    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        // Let’s assume there are 2 numbers a and b, both are smaller than n. If a is incremented by b*n, it becomes (a + b*n)
        // Now, (a + b*n) / n => b and (a + b*n) % n => a.
        for(int i = 0; i < n; i++) {
            int add = (a.get(a.get(i)) % n) * n;
            a.set(i, a.get(i) + add);
        }

        for(int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }
}
