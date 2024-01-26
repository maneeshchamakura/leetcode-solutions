class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        int mid = (int)Math.floor(Math.sqrt(n));
        for (int i=1; i<=mid; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) return i;
            }
        }
        // special case for mid
        if (mid*mid == n) {
            // perfect square
            mid -= 1;
        }         
        for (int i=mid; i >= 1; i--) {
            if (n % i == 0) {
                count++;
                if (count == k) return (n/i);
            }
        }
        return -1;
    }
    
}