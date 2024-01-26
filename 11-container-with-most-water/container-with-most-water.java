class Solution {
    public int maxArea(int[] height) {
        int low=0, high=height.length - 1;
        int res=Integer.MIN_VALUE;
        while (low < high) {
            int min = Math.min(height[low], height[high]);
            res = Math.max(res, min*(high - low));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return res;
    }
}