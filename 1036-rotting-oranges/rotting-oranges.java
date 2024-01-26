class Solution {
    static class Pair{
        int i, j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int rows = grid.length, cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int val = grid[i][j];
                if (val == 2) {
                    grid[i][j] = 0;
                    queue.add(new Pair(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                Pair p = queue.poll();
                int i = p.i, j=p.j;
                // north
                // i-1 j
                if(is_valid(i-1, j, rows, cols) && grid[i-1][j] == 1) {
                    grid[i-1][j] = 0;
                    queue.add(new Pair(i-1, j));
                }
                // west
                // i j-1
                if(is_valid(i, j-1, rows, cols) && grid[i][j-1] == 1) {
                    grid[i][j-1] = 0;
                    queue.add(new Pair(i, j-1));
                }
                // east
                // i j+1
                if (is_valid(i, j+1, rows, cols) && grid[i][j+1] == 1) {
                    grid[i][j+1] = 0;
                    queue.add(new Pair(i, j+1));
                }
                // south
                // i+1 j
                if (is_valid(i+1, j, rows, cols) && grid[i+1][j] == 1) {
                    grid[i+1][j] = 0;
                    queue.add(new Pair(i+1, j));
                }
            }
            if (!queue.isEmpty())count++;
        }
        for(int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
    public boolean is_valid(int i, int j, int rows, int cols) {
        return i>= 0 && i < rows && j >= 0 && j < cols;
    }
}