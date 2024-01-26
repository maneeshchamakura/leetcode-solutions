class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        for(String word: words) {
            boolean[] dp = new boolean[word.length() + 1];
            dp[0] = true;
            for (int len = 1; len <= word.length(); len++) {
                for (int j=(len == word.length() ? 1: 0); !dp[len] && j < len; j++) {
                    dp[len] = dp[j] && dictionary.contains(word.substring(j, len));
                }
            }
            if(dp[word.length()]) result.add(word);
        }
        return result;
    }
}