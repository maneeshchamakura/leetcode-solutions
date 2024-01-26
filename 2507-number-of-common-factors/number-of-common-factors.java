class Solution {
    public int commonFactors(int a, int b) {
        if (a < b) return commonFactors(b, a);
        int gcd = gcd(a, b);
        int count = 0;
        for (int i=1; i <= gcd; i++) {
            if (a % i == 0 && b % i == 0) count++;
        }
        return count;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}