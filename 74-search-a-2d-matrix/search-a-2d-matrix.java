class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n - 1;
        int row, col;
        while (low < high) {
            int mid = low + (high - low)/2;
            row = mid / n;
            col = mid % n;
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val < target) {
                low = mid + 1;                
            } else {
                high = mid - 1;
            }
        }
        row = low / n;
        col = low % n;
        return matrix[row][col] == target;
    }
}