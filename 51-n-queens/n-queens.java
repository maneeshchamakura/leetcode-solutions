class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>  result = new ArrayList<>();
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        positionQueens(0, n, new boolean[2*n -1], new boolean[2*n -1], result, arr);
        return result;
    }
    public void positionQueens(int row, int n, boolean[] diag1, boolean[] diag2, List<List<String>> result, int[] res) {
        if (row == n) {
            result.add(createResult(res));
            return;
        }
        for (int i=0; i<n; i++) {
            if (res[i] != -1 || diag1[row + i]) continue;
            int x = row - i;
            if (row - i < 0) {
                x = Math.abs(row - i) + (n -1);
            }
            if (diag2[x]) continue;
            res[i] = row;
            diag1[row + i] = true;
            diag2[x] = true;
            positionQueens(row+1, n, diag1, diag2, result, res);
            diag1[row + i] = false;
            diag2[x] = false;
            res[i] = -1;          
        }
        
    }
    public List<String> createResult(int[] res) {
        int n = res.length;
        char[][] chars = new char[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(chars[i], '.');
        }
        for (int i=0; i<res.length; i++) {
            int row = res[i];
            chars[row][i] = 'Q';
        }
        List<String> result = new ArrayList<>();
        for(char[] subarr: chars) {
            result.add(new String(subarr));
        }
        return result;
    }
}