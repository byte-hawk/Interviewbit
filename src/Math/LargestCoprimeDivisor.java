/*
You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
For example,

A = 30
B = 12
We return
X = 5
 */

package Math;

public class LargestCoprimeDivisor {
    /*
    Approach :
        Remove the common factors of A and B from A by
        diving A with the GCD of A & B
    */

    /**
     * Euclidean algorithm for GCD of a & b
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b){
        if(a < b)   return gcd(b , a);
        if(b == 0)    return a;
        return gcd(b, a % b);
    }

    /**
     * Find largest co-prime divisor of A & B
     * @param A
     * @param B
     * @return
     */
    public int cpFact(int A, int B) {
        int g = gcd(A , B);
        if(g == 1)  return A;
        return cpFact(A / g, B);
    }
}
