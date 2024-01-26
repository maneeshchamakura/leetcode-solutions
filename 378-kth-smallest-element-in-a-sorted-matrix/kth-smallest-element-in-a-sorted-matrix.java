class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start=matrix[0][0], end=matrix[n-1][n-1];
        while (start < end) {
            int mid = (start + (end - start)/2);
            int[] res = {matrix[0][0], matrix[n-1][n-1]};
            int count = countLessThanTarget(matrix, mid, res);
            if (count == k) {
                return res[0];
            } else if (count < k) {
                start = res[1];
            } else {
                end = res[0];
            }
        }
        return start;
    }
    public int countLessThanTarget(int[][] matrix, int target, int[] res) {
        int count=0;
        int n = matrix.length;
        int row=0, col=n-1;
        while (row < n && col >= 0) {
            if (matrix[row][col] > target) {
                res[1] = Math.min(res[1], matrix[row][col]);
                col--;
            } else {
                res[0] = Math.max(res[0], matrix[row][col]);
                count += (col + 1);
                row++;
            }
        }
        return count;
    }
}