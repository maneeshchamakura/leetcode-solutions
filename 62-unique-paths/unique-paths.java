class Solution {
    public int uniquePaths(int m, int n) {
        if (n > m) {
            n = (m + n) - (m=n);
        }
        // numerator from m till m+n-2
        // denominator from 1 till n-1
        long res=1;
        int numerator=m, denominator=1;
        while(numerator <= m+n-2 && denominator < n) {
            res *= numerator;
            res /= denominator;
            numerator++;
            denominator++;
        }
        return (int)res;
    }
}