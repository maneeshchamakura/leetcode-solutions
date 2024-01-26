class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void backtrack(int[] arr, int i, List<List<Integer>> result) {
        if (i == arr.length - 1) {
            result.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return;
        }
        for (int start = i; start < arr.length; start++) {
            swap(arr, start, i);
            backtrack(arr, i + 1, result);
            swap(arr, start, i);
        }
    }
}