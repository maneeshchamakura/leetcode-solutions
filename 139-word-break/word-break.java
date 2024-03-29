class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0, new HashMap<>());
    }
    public boolean wordBreak(String s, Set<String> words, int index, Map<Integer, Boolean> map) {
        if (index == s.length()) {
            return true;
        }
        if (map.containsKey(index)) return map.get(index);
        StringBuffer sb = new StringBuffer("");
        for (int i=index; i<s.length(); i++) {
            sb.append(s.charAt(i));
            if (words.contains(sb.toString())) {
                if (wordBreak(s, words, i+1, map)) {
                    return true;
                }
            }
        }
        map.put(index, false);
        return false;
    }
}