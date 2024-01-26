class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] min_cost = new int[n];
        min_cost[n-1] = cost[n-1];
        min_cost[n-2] = cost[n-2];
        for(int i=n-3; i >= 0; i--) {
            min_cost[i] = Math.min(min_cost[i+1], min_cost[i+2]) + cost[i];
        }
        return Math.min(min_cost[0], min_cost[1]);
    }
}