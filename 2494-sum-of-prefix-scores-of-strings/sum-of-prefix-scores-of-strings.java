class Solution {
    static class TrieNode {
        TrieNode[] chars;
        int count=0;
        TrieNode() {
            chars = new TrieNode[26];
            this.count = 0;
        }
    }
    
    public void addToTrie(TrieNode root, String s) {
        for(char c: s.toCharArray()) {
            int index = c - 'a';
            TrieNode next_node = root.chars[index];
            if (next_node == null) {
                next_node = new TrieNode();
                root.chars[index] = next_node;
                next_node.count++;
            } else {
                next_node = root.chars[index];
                next_node.count++;
            }
            root = next_node;
        }
    }
    
    public int find_score(TrieNode root, String s) {
        int score = 0;
        for(char c: s.toCharArray()) {
            int index = c - 'a';
            root = root.chars[index];
            score += root.count;       
        }
        return score;
    }
    
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            addToTrie(root, word);
        }
        List<Integer> result = new ArrayList<>();
        for(String word: words) {
            result.add(find_score(root, word));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}