class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        generatePermutations(nums, 0, result);
        return result;
    }
    public void generatePermutations(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> path = new ArrayList<>();
            for (int num: nums) path.add(num);
            result.add(path);
            return;
        }
        for (int i=index; i<nums.length; i++) {
            swap(nums, i, index);            
            generatePermutations(nums, index+1, result);
            swap(nums,i, index);
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}