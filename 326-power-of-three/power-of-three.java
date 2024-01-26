class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 0) return false;
        if (n == 0) return false;
        if (n == 1) return true;
        int q = n / 3;
        int r = n % 3;
        return (r== 0) && isPowerOfThree(q);
    }
}