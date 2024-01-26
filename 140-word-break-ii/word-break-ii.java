class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> cache = new HashMap<>();
        return wordBreak(s, 0, new HashSet<>(wordDict), cache);
    }
    public List<String> wordBreak(String s, int index, Set<String> words, Map<Integer, List<String>> cache) {
        if (index == s.length()) return null;
        if (cache.containsKey(index)) return cache.get(index);
        List<String> res = new ArrayList<>();
        
        
        for (int i=index; i<s.length(); i++) {
            String temp = s.substring(index, i+1);
            if (words.contains(temp)) {
                List<String> strings = wordBreak(s, i+1, words, cache);
                if (i+1 == s.length()) {
                    res.add(temp);
                } else {
                    if (strings.size() < 1) continue;
                    for (String str: strings) {
                        res.add(temp + " " + str);
                    }
                }
            }
        }
        
        cache.put(index, res);
        return res;
    }
}