class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s== null || s.isEmpty()) return 0;
        int start =0;
        int max = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for (int i=1; i<s.length();i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (start < i && s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                max = Math.max(max, i - start + 1);
            }
            set.add(c);
        }
        return max;
    }
}