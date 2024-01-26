class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> nums = new PriorityQueue<>(Collections.reverseOrder());
        for (int num: piles) {
            nums.add(num);
        }
        while(k-- > 0) {
            double num = nums.poll() + 0.0;
            int result = (int)(Math.ceil(num / 2.0));
            nums.offer(result);
        }
        int sum = 0;
        while(!nums.isEmpty()) {
            sum += nums.poll();
        }
        return sum;
    }
}