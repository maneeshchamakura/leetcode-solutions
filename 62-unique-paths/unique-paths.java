class Solution {
    public int uniquePaths(int m, int n) {
        int[][] distance = new int[m][n];
        Arrays.fill(distance[0], 1);
        int rows = distance.length, cols = distance[0].length;
        for(int i=0; i<rows; i++) {
            distance[i][0] = 1;
        }
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                distance[i][j] = distance[i-1][j] + distance[i][j-1];
            }
        }
        return distance[m-1][n-1];
    }
}