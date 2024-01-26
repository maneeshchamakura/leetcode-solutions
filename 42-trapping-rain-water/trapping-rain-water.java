class Solution {
    public int trap(int[] height) {
        int water_vol = 0;
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        // find the max_left including the current bar
        int max = -1;
        for(int i=0; i<n; i++) {
            max_left[i] = Math.max(max, height[i]);
            max = Math.max(max, height[i]);
        }
        // find the max_right including the current bar
        max = -1;
        for(int i=n-1; i>=0; i--) {
            max_right[i] = Math.max(max, height[i]);
            max = Math.max(max, height[i]);
        }
        for(int i=1; i<n-1; i++) {
            int current_bar_vol = Math.min(max_left[i-1], max_right[i+1]) - height[i];
            water_vol += (current_bar_vol < 0? 0: current_bar_vol);
        }
        return water_vol;
    }
}