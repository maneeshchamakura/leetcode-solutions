class Solution {
    public int deleteString(String s) {
        return process(s, 0, s.length(), new HashMap<>());
    }
    
    public int process(String s, int index, int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(index)) return memo.get(index);
        if (index == s.length() - 1) return 1;
        int max = 1;
        String current = s.substring(index, s.length());
        for(int len=1; len <= n/2; len++) {
            if (memo.containsKey(index + len - 1)) continue;
            if (!is_len_possible(current, len)) break;
            if (first_k_equal(current, len)) {
                max = Math.max(max, 1 + process(s, index + len, n, memo));
            }
        }
        memo.put(index, max);
        return memo.get(index);
    }
    
    public boolean is_len_possible(String s, int k) {
        return s.length() >= 2*k;
    }
    
    public boolean first_k_equal(String s, int k) {
        if (s.length() < 2*k) return false;
        String firstHalf = s.substring(0, k);
        String secondHalf = s.substring(k, 2*k);
        return firstHalf.equals(secondHalf);
    }
}