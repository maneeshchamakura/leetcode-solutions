class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rowStart=0, colStart=0, rowEnd=n-1, colEnd=n-1;
        while (rowStart < rowEnd) {
            int col1 = colStart, row1 = rowStart, col2= colEnd, row2 = rowEnd;
            while (col1 < colEnd && row1 < rowEnd && col2 > colStart && row2 > rowStart) {
                int x = matrix[rowStart][col1];
                int y = matrix[row1][colEnd];
                matrix[row1][colEnd] = x;
                int z = matrix[rowEnd][col2];
                matrix[rowEnd][col2] = y;
                int t = matrix[row2][colStart];
                matrix[row2][colStart] = z;
                matrix[rowStart][col1] = t;
                col1++;
                row1++;
                col2--;
                row2--;
            }
            rowStart++; colStart++;
            rowEnd--; colEnd--;
        }
    }
}