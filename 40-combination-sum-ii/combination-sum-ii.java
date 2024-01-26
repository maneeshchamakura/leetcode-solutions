class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if (target< 0) return;
        for (int i=index; i<candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) continue;
            //visited.add(i);
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i+1, result, list);
            list.remove(list.size() - 1);
            //visited.remove(i);
        }
    }
}