class Solution {
    public int minOperations(int[] nums, int k) {
        int[] bit_count = new int[32];
        for(int num: nums) {
            int pos = 0;
            int x = num;
            while(x > 0) {
                int rem = x % 2;
                bit_count[pos++] += (rem == 1 ? 1: 0);
                x /= 2;
            }
        }
        int[] res_bit = new int[32];
        int index = 0;
        int x = k;
        while(x > 0) {
            int rem = x % 2;
            res_bit[index++] += (rem == 1 ? 1: 0);
            x /= 2;
        }
        int ans = 0;
        for (int i=0; i<32; i++) {
            boolean needed_1 = (res_bit[i] == 1);
            boolean current_1 = (bit_count[i] % 2 == 1);
            if (needed_1  && !current_1) {
                ans++;
            } else if (!needed_1 && current_1) {
                ans++;
            }
        }
        return ans;
    }
    
}