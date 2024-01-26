class Solution {
    public int maxPalindromes(String s, int k) {
        int result = 0;
        for (int i=0; i<s.length(); i++) {
            if (is_palindrome(s, i, i+k-1)) {
                result++;
                i = i + k - 1;
            } else if(is_palindrome(s, i, i+k)) {
                result++;
                i = i + k;
            }
        }
        return result;
    }
    public boolean is_palindrome(String s, int startIndex, int endIndex) {
        if (endIndex >= s.length()) return false;
        while(startIndex <= endIndex) {
            char c1 = s.charAt(startIndex);
            char c2 = s.charAt(endIndex);
            if (c1 != c2) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }
}