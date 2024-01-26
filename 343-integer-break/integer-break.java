class Solution {

    static class Pair {
        int key, value, count;
        Pair(int key, int value, int count) {
            this.key = key;
            this.count = count;
            this.value = value;
        }
    }

    public int integerBreak(int n) {
        Map<Integer, Pair> map = new HashMap<>();
        Pair result = break_into_sum(n, n, map);
        if (result.count < 2) return 1;
        return result.value;
    }

    public Pair break_into_sum(int final_sum, int sum, Map<Integer, Pair> mem) {
        // int max = 0;
        if (mem.containsKey(sum)) return mem.get(sum);
        Pair result = new Pair(sum, sum, 1);
        int max_count = 0, max=0;
        for(int i=1; i < sum; i++) {
            int chosen = i;
            Pair rem_prod = break_into_sum(final_sum, sum - chosen, mem);
            max = Math.max(max, chosen*rem_prod.value);
            max_count = Math.max(max_count, 1 + rem_prod.count);
        }
        if (max > result.value || sum == final_sum) {
            result.value = max;
            result.count = max_count;
        }
        mem.put(sum, result);
        return result;
    }

}
