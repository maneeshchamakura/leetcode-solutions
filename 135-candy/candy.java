class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        // left to right
        for (int i=1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }
        // right to left
        for (int i=n-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], 1 + result[i+1]);
            }
        }
        return Arrays.stream(result).map(Integer::valueOf).sum();
    }
}