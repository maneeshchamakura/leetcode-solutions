class Solution {
    public void rotate(int[][] matrix) {
        // rotate can be done
        // transpose the matrix
        // swap columns
        int n = matrix.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                swap(i, j, matrix);
            }
        }
        
        // swap the columns
        for (int col = 0; col < n/2; col++) {
            for (int row = 0; row < n; row++) {
                // swap(row, col, matrix);
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n - 1 - col];
                matrix[row][n-1-col] = temp;
            }
        }
    }

    public void swap(int i, int j, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}