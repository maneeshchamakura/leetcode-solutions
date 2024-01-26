class Solution {
    public int reverse(int x) {
        if (x < 0) return reverseNegative(x);
        return reversePositive(x);
    }
    public int reversePositive(int n) {
        int res = 0;
        while (n > 0) {
            int rem = n % 10;
            int temp = res*10 + rem;
            int prev = (temp - rem)/10;
            if (prev != res) return 0;
            res = temp;
            n /= 10;
        }
        return res;
    }
    public int reverseNegative(int n) {
        int res = 0;
        res = n % 10;
        n /= 10;
        n *= -1;      
        while (n > 0) {
            int rem = n % 10;
            int temp = res*10 - rem;
            int prev = (temp + rem)/10;
            if (prev != res) return 0;
            res = temp;
            n /= 10;
        }
        return res;
    }
}