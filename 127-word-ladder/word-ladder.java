class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited1 = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        
        Set<String> visited2 = new HashSet<>();        
        Queue<String> queue2 = new LinkedList<>();
        
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        queue1.add(beginWord);visited1.add(beginWord);
        queue2.add(endWord);visited2.add(endWord);
        int len1 = 1, len2 = 1;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int len = performBFS(queue1, visited1, len1, len2, visited2, wordSet);
            if (len != -1) return len;
            len1++;
            len = performBFS(queue2, visited2, len2, len1, visited1, wordSet);
            len2++;
            if (len != -1) return len;
        }
        return 0;
    }
    public int performBFS(Queue<String> queue, Set<String> visited, int len1, int len2, Set<String> otherVisited, Set<String> wordSet) {
        int size = queue.size();
        while (size-- > 0) {
            String current = queue.poll();
            char[] chars = current.toCharArray();
            for (int i=0; i<chars.length; i++) {
                char originalChar = chars[i];
                for (char c='a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;
                    chars[i] = c;
                    String newString = String.valueOf(chars);
                    if (otherVisited.contains(newString)) {
                        return len1 + len2;
                    }
                    if (wordSet.contains(newString) && !visited.contains(newString)) {
                        visited.add(newString);
                        queue.offer(newString);
                    }
                }
                chars[i] = originalChar;
            }
        }
        return -1;
    }
}