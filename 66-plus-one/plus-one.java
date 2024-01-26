class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{};
        int n = digits.length;
        boolean isAllNines = true;
        for(int num: digits) {
            if (num != 9) {
                isAllNines = false;
                break;
            }
        }
        int[] res = new int[isAllNines? n+1: n];
        int carry = 1;
        int index = res.length - 1;
        for(int i=n-1; i>=0; i--) {
            int sum = carry + digits[i];
            if (sum == 10) {
                carry = 1;
                res[index] = sum%10;
            } else {
                res[index] = sum;
                carry = 0;
            }
            index -= 1;
        }
        if (index == 0) {
            res[index] = 1;
        }
        return res;
    }
}