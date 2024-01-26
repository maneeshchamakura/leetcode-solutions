class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start=0, max=1;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {               
                start = map.get(c) + 1;
            }
            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}