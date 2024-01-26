class Solution {
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0 || Arrays.stream(nums).sum() == 0 ) return 0;
        if (Arrays.stream(nums).sum() == nums.length) {
            return nums.length - 1;
        }
        List<Integer> list = new ArrayList<>();
        int i=0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                list.add(0);
                i++;
            } else {
                int count = 0;
                while (i < nums.length && nums[i] == 1) {
                    count++;
                    i++;
                }
                list.add(count);
            }
        }
        int max = 0;
        for (i=0; i<list.size(); i++) {
            if (list.get(i) == 0) continue;
            max = Math.max(max, list.get(i));
            if (i + 2 < list.size()) {
                max = Math.max(max, list.get(i) + list.get(i+2));
            }
        }
        return max;
    }
}