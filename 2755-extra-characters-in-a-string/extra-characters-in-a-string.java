class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean is_word = false;
        TrieNode() {
            this.children = new HashMap<>();
            this.is_word = false;
        }
    }
    public TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word: dictionary) {
            TrieNode temp = root;
            for(char c: word.toCharArray()) {
                temp.children.putIfAbsent(c, new TrieNode());
                temp = temp.children.get(c);
            }
            temp.is_word = true;
        }
        return root;
    }
    public int dp(String s, int n, TrieNode root) {         
        int[] memo = new int[s.length()+1];
        for(int i=n-1; i>=0; i--) {
            int ans = 1+memo[i+1];
            TrieNode node = root;
            for(int index = i; index < n; index++) {
                char c = s.charAt(index);
                if (!node.children.containsKey(c)) break;
                node = node.children.get(c);
                if (node.is_word) {
                    ans = Math.min(ans, memo[index + 1]);
                }
            }
            memo[i] = ans;
        }
        return memo[0];
    }
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = buildTrie(dictionary);
        return dp(s, s.length(), root);
    }

}