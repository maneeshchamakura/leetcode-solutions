class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[9];
        for (int i=1; i<=9; i++) {
            arr[i-1] = i;
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, n, result, new ArrayList<>(), k);
        return result;
    }
    
    public void backtrack(int[] arr, int index, int target, List<List<Integer>> result, List<Integer> list, int k) {
        if (target == 0) {
            if (list.size() == k) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if (target < 0) return;
        for (int i=index; i<arr.length; i++) {
            if (arr[i] > target) break;
            list.add(arr[i]);
            backtrack(arr, i+1, target - arr[i], result, list, k);
            list.remove(list.size() - 1);
        }        
    }
}