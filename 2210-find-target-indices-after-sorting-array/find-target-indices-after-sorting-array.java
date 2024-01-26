class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int index = Arrays.binarySearch(nums, target);
        if (index < 0 || index >= nums.length) return result;
        int left = index, right = index;
        // go to left
        while(left > 0 && nums[left-1] == target){
            left--;
        }
        // go to right
        while (right < nums.length - 1 && nums[right+1] == target) {
            right++;
        }
        if (left == right) {
            result.add(index);
            return result;
        }
        for (int i=left; i<= right; i++) {
            result.add(i);
        }
        return result;
    }
}