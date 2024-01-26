class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict, new HashMap<>());
    }
    
    public List<String> wordBreak(String s ,int index, List<String> wordDict, Map<Integer, List<String>> cache) {
        List<String> result = new ArrayList<>();
        String current = s.substring(index);
        if (cache.containsKey(index)) return cache.get(index);
        for(String word: wordDict) {
            if (current.startsWith(word)) {
                StringBuffer sb = new StringBuffer("");
                if (current.length() == word.length()) {
                    result.add(current);
                    continue;
                }                
                int j = index;
                j+= word.length();
                List<String> strings = wordBreak(s, j, wordDict, cache);
                for(String temp: strings) {
                    result.add(word + " " + temp);
                } 
            }
        } 
        cache.put(index, result);
        return result;
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