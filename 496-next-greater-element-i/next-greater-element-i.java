class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i=0; i<nums1.length; i++) {
            int num = nums1[i];
            if (map.containsKey(num)) {
                res[i] = map.get(num);
            }
        }
        return res;
    }
}