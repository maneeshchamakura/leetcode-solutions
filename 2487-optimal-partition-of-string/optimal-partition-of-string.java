class Solution {
    public int partitionString(String s) {
        int count = 0;
        Set<Character> window_chars =new HashSet<>();
        window_chars.add(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            char c= s.charAt(i);
            if (window_chars.contains(c)) {
                count++;
                window_chars.clear();
            }
            window_chars.add(c);
        }
        if (!window_chars.isEmpty()) count++;
        return count;
    }
}