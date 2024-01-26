class Solution {
    public int firstMissingPositive(int[] A) {
        int max = Integer.MAX_VALUE;
        int n = A.length;
        boolean hasMaxAlready = false;
        for (int i=0; i<n; i++) {
            // edge case when length is Integer.MAX_VALUE
            if (A[i] == max) {
                hasMaxAlready = true;
            }
            // mark the non-contributing elements zero & negative values to Integer.MAX_VALUE
            if (A[i] <= 0) {
                A[i] = max;
            }
        }
        for (int i=0; i<n; i++) {
            int current = Math.abs(A[i]) - 1;
            // mark the indices negative
            if (current >= 0 && current < n && A[current] > 0) {
                A[current]  *= -1;
            }
        }
        for (int i=0; i<n; i++) {
            if (A[i] > 0) {
                return i+1;
            }
        }
        // edge case when the length is max
        if (!hasMaxAlready && n == max) {
            return max;
        }
        return n+1;
    }
}