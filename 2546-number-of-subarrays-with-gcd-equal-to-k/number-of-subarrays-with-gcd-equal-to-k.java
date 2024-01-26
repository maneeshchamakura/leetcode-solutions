class Solution {
    public int subarrayGCD(int[] nums, int k) {
        // int res = (int)Arrays.stream(nums).filter(a -> a == k).count();
        int n = nums.length;
        int result = 0;
        for(int len=1; len <= n; len++) {
            for(int i=0; i<= n - len; i++) {
                if (is_valid(nums, i, i + len - 1, k)) {
                    result++;
                }
            }
        }
        return result;
    }
    
    public boolean is_valid(int[] arr, int start, int end, int k) {
        int res = arr[start];
        for(int i=start+1; i<=end; i++) {
            res = gcd(res, arr[i]);
        }
        return res == k;
    }
    
    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b%a, a);
    }
}