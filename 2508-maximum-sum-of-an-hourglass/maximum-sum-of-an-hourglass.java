class Solution {
    public int maxSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<List<Integer>> row_prefix_sum = new ArrayList<>();
        List<List<Integer>> col_prefix_sum = new ArrayList<>();
        for (int i=0; i<rows; i++) {
            row_prefix_sum.add(new ArrayList<>());
        }
        for(int i=0; i<cols; i++) {
            col_prefix_sum.add(new ArrayList<>());
        }
        // calculate row_prefix_sum for each row        
        for(int i=0; i<rows; i++) {
            int sum = 0;
            for(int j=0; j<cols; j++) {
                sum += grid[i][j];
                row_prefix_sum.get(i).add(sum);
            }
        }
        // calculate col_prefix_sum for each col
        for (int i=0; i<cols; i++) {
            int sum = 0;
            for (int j=0; j<rows; j++) {
                sum += grid[j][i];
                col_prefix_sum.get(i).add(sum);
            }
        }
        row_prefix_sum.forEach(System.out::println);
        col_prefix_sum.forEach(System.out::println);
        int result = 0;
        for (int j= 1; j < cols - 1; j++) {
        // find all hour glasses where
        // j is the center
            for (int i=0; i <= rows - 3; i++) {
                // top row is i
                // bottom row is i+2
                // row i col j-1 to row i col j+1
                // row i+2 col j-1 to row i col j+1
                int top_sum = row_prefix_sum.get(i).get(j+1) - (j == 1 ? 0: row_prefix_sum.get(i).get(j-2));
                int bottom_sum = row_prefix_sum.get(i+2).get(j+1) - (j == 1 ? 0: row_prefix_sum.get(i+2).get(j-2));
                // int col_sum = col_prefix_sum.get(j).get(i+2) - (i == 0 ? 0: col_prefix_sum.get(j).get(i-1));
                int col_sum = grid[i+1][j];
                System.out.println(top_sum +"," + bottom_sum + "," + col_sum);
                result = Math.max(result, top_sum + bottom_sum + col_sum);
            }
        }
        return result;
    }
}