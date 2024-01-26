class Solution {
    public int[] plusOne(int[] digits) {
        int result_len = digits.length;
        int i=0;
        while (i<digits.length && digits[i] == 9) {
            i++;
        }
        if (i == digits.length) {
            result_len++;
        }
        int[] result = new int[result_len];
        int index = result_len - 1;
        i = digits.length - 1;
        int carry = 1;
        while (i >= 0) {
            if (carry == 1) {
                if (digits[i] == 9) {
                    result[index] = 0;
                    carry = 1;
                } else {
                    result[index] = digits[i] + 1;
                    carry = 0;
                }
            } else {
                result[index] = digits[i];
            }
            index--;
            i--;
        }
        if (carry == 1) {
            result[0] = carry;
        }
        return result;
    }
}