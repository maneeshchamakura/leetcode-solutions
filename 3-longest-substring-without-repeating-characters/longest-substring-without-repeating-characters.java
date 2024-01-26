class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int max = 1;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                // repetition found
                int index = map.get(c);
                while (start <= index) {
                    map.remove(s.charAt(start++));
                }                
            } else {               
                max = Math.max(max, i - start + 1);
            }
            map.put(c, i);
        }
        return  max;
    }
}