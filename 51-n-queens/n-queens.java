class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>  result = new ArrayList<>();        
        positionQueens(0, new HashSet<>(), n, new HashSet<>(), new HashSet<>(), result, new int[n]);
        return result;
    }
    public void positionQueens(int row, Set<Integer> columns, int n, Set<Integer> set1, Set<Integer> set2, List<List<String>> result, int[] res) {
        if (row == n) {
            result.add(createResult(res));
            return;
        }
        for (int i=0; i<n; i++) {
            if (columns.contains(i) || set1.contains(i) || set2.contains(i)) continue;
            res[i] = row;
            columns.add(i);
            Set<Integer> leftSet = new HashSet<>();
            Set<Integer> rightSet = new HashSet<>();
            for (int num: set1) {
                if (num - 1 >= 0) leftSet.add(num -1);
            }
            for (int num: set2) {
                if (num + 1 < n) rightSet.add(num + 1);
            }
            if (i - 1 >= 0) leftSet.add(i -1);
            if (i + 1 < n) rightSet.add(i + 1);
            positionQueens(row+1, columns, n, leftSet, rightSet, result, res);
            columns.remove(i);            
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