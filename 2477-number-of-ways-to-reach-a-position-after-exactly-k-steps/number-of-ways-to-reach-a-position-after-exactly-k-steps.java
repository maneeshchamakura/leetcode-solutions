class Solution {
    
    public int mod = (int)1e9 + 7;
    
    public int numberOfWays(int startPos, int endPos, int k) {
        return possibleWay(startPos, endPos, 0, k, new HashMap<>());
    }
    
    public int possibleWay(int start, int end, int steps, int k, Map<String, Integer> memo) {
        String key = start +"," + steps;
        if (memo.containsKey(key)) return memo.get(key);
        if (steps == k) {
            if (start == end) return 1;
            return 0;
        }
        int ans1 = possibleWay(start + 1, end, steps + 1, k, memo);
        int ans2 = possibleWay(start - 1, end, steps + 1, k, memo);
        int result = (ans1%mod + ans2%mod)%mod;
        memo.put(key, result);
        return result;
    }
}