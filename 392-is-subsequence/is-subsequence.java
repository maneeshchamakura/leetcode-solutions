class Solution {
    public boolean isSubsequence(String s, String t) {
        // NOTE: clean solution
        int i=0, j=0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        return i==s.length();
    }
}