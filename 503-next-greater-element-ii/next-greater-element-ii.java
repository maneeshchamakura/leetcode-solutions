class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i=0; i<n; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                result[stack.pop()] = num;
            }
            stack.push(i);
        }
        int i=0, max=Integer.MIN_VALUE;
        while(i<n-1 && !stack.isEmpty()) {
            // remove unnecessary elements from stack
            while (!stack.isEmpty() && i >= stack.peek()) {
                stack.pop();
            }
            max = Math.max(max, nums[i]);
            // check whether this can be the maximum element
            while (!stack.isEmpty() && i < stack.peek() && max > nums[stack.peek()]) {
                result[stack.pop()] = max;
            }
            i++;
        }
        return result;
    }
}