class Solution {
    public int trap(int[] height) {
        // find the amount of water on every bar
        if (height == null || height.length < 3) return 0;
        int volume = 0, n = height.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int current = height[i];
            while (!stack.isEmpty() && current > height[stack.peek()]) {
                int popped_height = height[stack.pop()];
                if (stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(current, height[stack.peek()]) - popped_height;
                volume += (distance*bounded_height);
            }
            stack.push(i);
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