class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        // String digits_count = String.valueOf(n).length();
        if (n == 0) return 0;
        if (sum_digits(n) <= target) return 0;
        long d = 10;// 10 100 1000
        long original = n;
        while (true) {
            if (d > n) return d - original;
            n /= d;
            n *= d;
            n += d;
            if (sum_digits(n) <= target) return n - original;
            d *= 10;
        }
    }


    
    public int sum_digits(long n) {
        int count = 0;
        while(n > 0) {
            count += (n % 10);
            n /= 10;
        }
        return count;
    }
}