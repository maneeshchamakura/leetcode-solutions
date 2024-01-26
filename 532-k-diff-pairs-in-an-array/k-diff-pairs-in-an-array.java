class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> indexMap= new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int count = indexMap.getOrDefault(nums[i], 0);
            count++;
            indexMap.put(nums[i], count);
        }
        int res = 0;
        if (k == 0) {
            for(int key: indexMap.keySet()) {
                if (indexMap.get(key) > 1) {
                    res++;
                }
            }
            return res;
        }
        for (int key: indexMap.keySet()) {
            int right = key + k;
            if (indexMap.containsKey(right)) {
                res++;
            }
        }
        return res;
    }
}