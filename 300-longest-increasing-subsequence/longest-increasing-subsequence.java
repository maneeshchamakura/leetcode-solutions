class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int index = Collections.binarySearch(piles, num);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == piles.size()) {
                piles.add(num);
            } else {
                piles.set(index, num);
            }
        }
        return piles.size();
    }
}