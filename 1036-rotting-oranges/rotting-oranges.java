class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i*cols + j);
                }
            }
        }
        int time = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int code = queue.poll();
                int r = code / cols;
                int c = code % cols;
                for (int k=0; k<4; k++) {
                    int newR = r + dx[k];
                    int newC = c + dy[k];
                    if (newR>= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        queue.add(newR*cols + newC);
                    }
                }
            }
            if (!queue.isEmpty())
            time++;
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}