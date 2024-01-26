class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = heights.length;
        for(int i=1; i<n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                int height = heights[index];
                int width = stack.isEmpty() ? i: i - stack.peek() - 1;
                int area = width * height;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int height = heights[index];
            int width = stack.isEmpty() ? n: n - stack.peek() - 1;
            int area = width * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}