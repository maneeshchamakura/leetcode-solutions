class Solution {
    public int[] applyOperations(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                index++;
            }
            else if (index == nums.length - 1) {
                result.add(nums[index]);
                index++;
            } else {
                if (nums[index] == nums[index + 1]) {
                    result.add(nums[index]*2);
                    index+=2;
                } else {
                    result.add(nums[index]);
                    index++;
                }
            }
        }
        int n = nums.length;
        while(n - result.size() > 0) {
            result.add(0);
        }
        return result.stream().mapToInt(a -> (int)a).toArray();
    }
}