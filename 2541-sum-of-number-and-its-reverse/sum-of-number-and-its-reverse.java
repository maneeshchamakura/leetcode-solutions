class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) return true;
        int n = String.valueOf(num+"").length();
        for(int i=0; i<n; i++) {
            if(is_valid(num, 0, 0, n-i)) return true;
        }
        return false;
    }
    
    public int reverse(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum = sum*10 + rem;
            num /= 10;
        }
        return sum;
    }
    
    public boolean is_valid(int num, int sum, int index, int n) {
        if (n <= 0) return false;
        if (index == n) {
            int val1 = sum;
            int val2 = reverse(sum);
            if (val1 + val2 == num) {
                return true;
            }
            return false;
        }
        // form every possible value
            // 0 to 9
        int start = 0;
        if (index == 0) {
            start = 1;
        }
        for (int i=start; i<=9; i++) {
            int temp_sum = sum*10 + i;
            if(is_valid(num, temp_sum, index + 1, n)) return true;
        }
        return false;
    }
}