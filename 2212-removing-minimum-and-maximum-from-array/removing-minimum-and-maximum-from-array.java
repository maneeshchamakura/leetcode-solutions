class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int min_element = Arrays.stream(nums).min().orElseThrow();
        int max_element = Arrays.stream(nums).max().orElseThrow();
        int min_index = IntStream.range(0, nums.length).filter(i -> nums[i] == min_element).findFirst().getAsInt();
        int max_index = IntStream.range(0, nums.length).filter(i -> nums[i] == max_element).findFirst().getAsInt();
        int min_from_left = min_index + 1;
        int min_from_right = nums.length - min_index;
        int max_from_left = max_index + 1;
        int max_from_right = nums.length - max_index;
        boolean max_from_left_best = max_from_left <= max_from_right;
        boolean min_from_left_best = min_from_left <= min_from_right;
        int distance_max = Math.min(max_from_left, max_from_right);
        int distance_min = Math.min(min_from_left, min_from_right);
        int result = 0;
        int[] newArray;
        boolean removed_min = false;
        if (distance_min < distance_max) {
            removed_min = true;
            // remove min
            result += distance_min;
            // left or right
            if (min_from_left_best) {
                newArray = Arrays.copyOfRange(nums, min_index + 1, nums.length);
            } else {
                newArray = Arrays.copyOfRange(nums, 0, min_index);
            }
        } else {
            // remove max
            result += distance_max;
            // left or right
            if (max_from_left_best) {
                newArray = Arrays.copyOfRange(nums, max_index + 1, nums.length);
            } else {
                newArray = Arrays.copyOfRange(nums, 0, max_index);
            }
        }
        int target = removed_min ? max_element: min_element;
        // find the distance of this target in the newArray
        int target_index = IntStream.range(0, newArray.length).filter(i -> newArray[i] == target).findFirst().getAsInt();
        if (target_index + 1 < newArray.length - target_index) {
            result += target_index + 1;
        } else {
            result += newArray.length - target_index;
        }
        return result;
    }
}