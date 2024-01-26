class Solution {
    public int findKOr(int[] nums, int k) {
        // find the count of elements in nums 
        // find the set bits of them of nums
        int n = nums.length;
        int[] set_count = new int[32];
        for(int num: nums) {
            // find the binary rep
            String binary_string = Integer.toBinaryString(num);
            for (int i=binary_string.length() - 1; i >= 0; i--) {
                int bit = binary_string.charAt(i) - '0';
                int index = binary_string.length() - 1 - i;
                set_count[index] += bit;
            }
        }
        int result = 0;
        int mul = 1;
        for (int i=0; i<32; i++) {
            boolean is_valid = set_count[i] >= k;
            if (is_valid) {
                result += (mul);
            }
            mul *= 2;
        }
        return result;
    }
}