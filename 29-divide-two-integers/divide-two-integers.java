class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (dividend < 0) == (divisor < 0);
        dividend = (dividend > 0) ? -dividend: dividend;
        divisor = (divisor > 0) ? -divisor: divisor;
        int res = div(dividend, divisor);
        return sign ? res: -res;
    }
    public int div(int dividend, int divisor) {
        if (dividend > divisor) return 0;
        int curSum =divisor*2, prevSum=divisor, q=1;
        while (curSum < prevSum && curSum >= dividend) {
            prevSum = curSum;
            curSum += curSum;
            q += q;
        }
        return q + div(dividend - prevSum, divisor);
    }
}