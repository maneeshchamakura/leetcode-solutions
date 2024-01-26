class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int[] bits = new int[32];
        int result = 1;
        String temp = Integer.toBinaryString(nums[0]);
        for (int i=temp.length() - 1; i >= 0; i--) {
            bits[temp.length() + 1 - i] = (temp.charAt(i) - '0');
        }
        int window_start = 0;
        for (int i=1; i<n; i++) {
            String s = Integer.toBinaryString(nums[i]);
            // 12: 1100
            // check if the current num
            // can go with the window            
            if (!is_and_true(bits, s)) {
                while(window_start < i) {
                    // remove the window_start bit string from bits
                    String leftmost = Integer.toBinaryString(nums[window_start]); 
                    window_start++;
                    // remove the leftmost string from bits
                    for (int k=leftmost.length() - 1; k >= 0; k--) {
                        if (leftmost.charAt(k) == '1') {
                            bits[leftmost.length() + 1 - k] = 0;
                        }
                    }
                    if(is_and_true(bits, s)) break;
                }
            } else {
                // i - window_start + 1
                result = Math.max(result, i - window_start + 1);
            }
            // add the s string to the bits array
            for (int k=s.length() - 1; k >= 0; k--) {
                if (s.charAt(k) == '1') {
                    bits[s.length() + 1 - k] = 1;
                }
            }
        }
        return result;
    }
    
    public boolean is_and_true(int[] bits, String s) {
        for (int j=s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == '1' && bits[s.length() + 1 - j] == 1) {
                return false;
            }
        }
        return true;
    }
    
}