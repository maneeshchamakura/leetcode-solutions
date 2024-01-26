class Solution {
    public int trap(int[] height) {
        // find the amount of water on every bar
        if (height == null || height.length < 3) return 0;
        int volume = 0, n = height.length;
        for (int i=0; i<n; i++) {
            // find max bar on left
            int maxLeft = maxOnLeft(height, i);
            // find max bar on right
            int maxRight = maxOnRight(height, i);
            volume += Math.min(maxLeft, maxRight) - height[i];
        }
        return volume;
    }
    
    public int maxOnLeft(int[] arr, int index) {
        int leftMax = arr[index];
        while (index >= 0) {
            leftMax = Math.max(leftMax, arr[index]);
            index--;
        }
        return leftMax;
    }
    public int maxOnRight(int[] arr, int index) {
        int rightMax = arr[index];
        while (index < arr.length) {
            rightMax = Math.max(rightMax, arr[index]);
            index++;
        }
        return rightMax;
    }
}