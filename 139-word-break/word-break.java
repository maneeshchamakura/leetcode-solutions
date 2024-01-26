class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return break_word(s, new HashSet<>(wordDict), new HashMap<>());
    }

    public boolean break_word(String s, Set<String> words, Map<String, Boolean> map) {
        if (s.isEmpty()) return true;
        if (map.containsKey(s)) return map.get(s);
        for (int i=0; i<s.length(); i++) {
            String sub_str = s.substring(0, i+1);
            if (words.contains(sub_str)) {
                boolean possible = break_word(s.substring(i+1), words, map);
                if (possible) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}