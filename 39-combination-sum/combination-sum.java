class Solution {
    List<Map<Integer, List<List<Integer>>>> cache;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        cache = new ArrayList<>();
        for (int i=0; i<candidates.length; i++) {
            cache.add(new HashMap<>());
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = combinationSum(candidates, 0, target);
        if (res == null) {
            return new ArrayList<>();
        }
        return res;
    }
    public List<List<Integer>> combinationSum(int[] nums, int i, int target) {
        if (i >= nums.length || nums[i] > target) return null;
        if (cache.get(i).containsKey(target)) {
            return cache.get(i).get(target);
        }
        // take this number any number of times
        List<List<Integer>> local = new ArrayList<>();
        int temp = target;
        List<Integer> path = new ArrayList<>();
        while (nums[i] <= target) {
            target -= nums[i];
            path.add(nums[i]);
            if (target == 0) {
                local.add(new ArrayList<>(path));
                break;
            }
            List<List<Integer>> answers = combinationSum(nums, i+1, target);
            if (answers != null) {
                for (List<Integer> answer: answers) {
                    List<Integer> tempList= new ArrayList<>(path);
                    tempList.addAll(answer);
                    local.add(tempList);
                }
            }
        }
        // don't take this number
        List<List<Integer>> answers = combinationSum(nums, i+1, temp);
        if (answers != null)
        local.addAll(answers);
        cache.get(i).put(target, local);
        return local;
    }
}