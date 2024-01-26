class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] mat = new int[n][n];
        char[][] board = new char[n][n];
        for(char[] sub_arr: board) Arrays.fill(sub_arr, '.');
        backtrack(mat, board, n, 0, result);
        return result;
    }

    public void backtrack(int[][] mines, char[][] board, int n, int start, List<List<String>> result) {
        if (start == n) {
            List<String> ans = new ArrayList<>();
            for(char[] row: board) ans.add(new String(row));
            result.add(ans);
            return;
        }
        for (int i=0; i<n; i++) {
            if (mines[start][i] == 0) {
                // put queen
                board[start][i] = 'Q';
                put_queen(mines, start, i, n, 1);
                backtrack(mines, board, n, start + 1, result);
                put_queen(mines, start, i, n, -1);
                board[start][i] = '.';
            }
        }
    }

    void put_queen(int[][] mat, int row, int col, int n, int val) {
        mat[row][col] += val;
        // go along row and col
        for (int i=0; i<n; i++) {
            if (i != col) {
                mat[row][i] += val;
            }
            if (i != row) {
                mat[i][col] += val;
            }
        }
        // go along north east
        int temp_row = row, temp_col = col;
        while (temp_row - 1 >= 0 && temp_col + 1 < n) {
            mat[temp_row - 1][temp_col + 1] += val;
            temp_row--;
            temp_col++;
        }
        // go along north west
        temp_row = row; temp_col = col;
        while (temp_row - 1 >= 0 && temp_col - 1 >= 0) {
            mat[temp_row - 1][temp_col -1] += val;
            temp_row--;
            temp_col--;
        }
        // go along south west
        temp_row = row; temp_col = col;
        while (temp_row + 1 < n && temp_col - 1 >= 0) {
            mat[temp_row + 1][temp_col - 1] += val;
            temp_row++;
            temp_col--;
        }
        // go along south east
        temp_row = row; temp_col = col;
        while (temp_row + 1 < n && temp_col + 1 < n) {
            mat[temp_row + 1][temp_col + 1] += val;
            temp_row++;
            temp_col++;
        }        
    }
}