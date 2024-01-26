class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += cardPoints[i];
        }
        int res = sum;
        
        if (k == n) return res;
        int index = k-1;
        
        for (int i=n-1; i >= n - k; i--) {
            sum -= cardPoints[index];
            sum += cardPoints[i];
            res = Math.max(res, sum);
            index--;
        }
        
        return res;
    }
}