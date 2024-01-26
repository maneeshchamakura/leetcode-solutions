class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int opsToLeft = 0;
        int ballsToLeft = 0;
        for (int i=0; i<n; i++) {
            leftSum[i] = opsToLeft;
            ballsToLeft += (boxes.charAt(i) - '0');
            opsToLeft += ballsToLeft;
        }
        int opsToRight = 0;
        int ballsToRight = 0;
        for (int i=n-1; i>=0; i--) {
            rightSum[i] = opsToRight;
            ballsToRight += (boxes.charAt(i) - '0');
            opsToRight += ballsToRight;
        }
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            ans[i] = leftSum[i] + rightSum[i];
        }
        return ans;
    }
}