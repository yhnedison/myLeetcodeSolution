// DP
// Suppose f(n) = counts for n 
// f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-2)*f(1) + f(n-1)*f(0)
class Solution {
    public int numTrees(int n) {
        int[] C = new int[n+1];
        C[0] = 1;
        C[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                C[i] += C[j-1] * C[i-j] ;
            }
        }
        return C[n];
    }
}