class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int low = 0, high = height.length - 1;
        int count = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        while (low <= high) {        
            leftMax = Math.max(leftMax, height[low]);
            rightMax = Math.max(rightMax, height[high]);
            if (leftMax < rightMax) {
                count += (leftMax - height[low]);
                low++;                
            } else {
                count += (rightMax - height[high]);
                high--;                
            }
        }
        return count;
    }
}