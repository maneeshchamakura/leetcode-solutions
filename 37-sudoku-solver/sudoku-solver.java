class Solution {
    public void solveSudoku(char[][] board) {
        solve_sudoku(board, 0, 0);
    }

    public boolean solve_sudoku(char[][] board, int row, int col) {
        if (row == board.length) return true;
        if (col == board[0].length) {
            // reached end of the row go to next
            return solve_sudoku(board, row+1, 0);
        }
        if (board[row][col] != '.') {
            // if already filled
            return solve_sudoku(board, row, col + 1);
        }
        for (char num = '1'; num <= '9'; num += 1) {
            if(is_correct_placement(board, row, col, num)) {
                board[row][col] = num;
                if (solve_sudoku(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean is_correct_placement(char[][] board, int row, int col, char num) {
        for (int i=0; i<9; i++) {
            if (board[i][col] == num) return false;
            if (board[row][i] == num) return false;
            int subrow = 3 *(row/3) + i/3;
            int subcol = 3 *(col/3) + i%3;
            if (board[subrow][subcol] == num) return false;
        }
        return true;
    }
}