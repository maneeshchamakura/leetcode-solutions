class Solution {
    class TrieNode {
        Map<Character, TrieNode> map;
        int count;
        TrieNode() {
            map = new HashMap<>();
            count = 0;
        }
        int getSize() {
            return map.size();
        }
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) return "";
        TrieNode root = new TrieNode();
        for(String s:strs) {
            insert(root, s);
        }
        int end=0;
        while(end<strs[0].length() && root.getSize() == 1 && root.count == strs.length) {
            root = root.map.get(strs[0].charAt(end));
            end++;            
        }
        return strs[0].substring(0, end);
    }
    
    public void insert(TrieNode root, String s) {
        for(char c: s.toCharArray()) {
            root.count++;
            if (!root.map.containsKey(c)) {
                root.map.put(c, new TrieNode());
            }
            root = root.map.get(c);
        }        
    }
}