class Solution {
    public boolean isUgly(int n) {
        if (n < 1) return false;
        if (n < 6) return true;
        int temp = n;
        int res = 1;
        while(temp%2 == 0) {
            temp /= 2;
            res *= 2;
        }
        while(temp%3 == 0) {
            temp /= 3;
            res *= 3;
        }
        while(temp%5 == 0) {
            temp /= 5;
            res *= 5;
        }
        return res == n;
    }
}