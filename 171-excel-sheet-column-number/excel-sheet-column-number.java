class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        // int[] nums = new int[n+1];
        // nums[0] = 1;
        // int prevNumCount = 0;
        // for (int i=1; i<nums.length; i++) {
        //     nums[i] = 26 * nums[i-1];
        //     if (i != nums.length - 1) {
        //         prevNumCount += nums[i];
        //     }
        // }
        // int index = n-1;
        // for(char c: s.toCharArray()) {
        //     prevNumCount += (c - 'A')*nums[index];
        //     index--;
        // }
        // return prevNumCount + 1;
        int temp = pow(26, n-1);
        int prev = temp - 1;
        prev /= 25;
        prev *= 26;        
        //System.out.println(temp);
        for(char c: s.toCharArray()) {
            prev += (c - 'A')*temp;
            temp /= 26;
        }
        return prev + 1;
    }
    public int pow(int a, int n) {
        int res = 1;
        int temp = a;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= temp;
            }            
            temp *= temp;
            n >>= 1;
        }
        return res;
    }
}