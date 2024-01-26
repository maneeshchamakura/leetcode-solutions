class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }
    
    public void backtrack(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            if (candidates[i] > target) break;
            int sum = candidates[i], count=0;
            while (sum <= target) {
                list.add(candidates[i]);
                backtrack(candidates, target - sum, i+1, result, list);
                count++;
                sum += candidates[i];
            }
            for (int k=0; k<count; k++) {
                list.remove(list.size() - 1);
            }            
        }
    }
}