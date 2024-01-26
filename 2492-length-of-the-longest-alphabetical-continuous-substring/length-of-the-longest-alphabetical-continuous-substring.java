class Solution {
    public int longestContinuousSubstring(String s) {
        // int start = 0;
        int n = s.length();
        int index = 0;
        int result = 1;
        while (index < n) {
            // see the contiguous substring start from character at index
            char c = s.charAt(index);
            int start = index;
            while (index + 1 < n && s.charAt(index + 1) == c + 1) {
                index++;
                c = s.charAt(index);
            }
            result  = Math.max(result, index - start + 1);
            index++;
        }
        return result;
    }
}