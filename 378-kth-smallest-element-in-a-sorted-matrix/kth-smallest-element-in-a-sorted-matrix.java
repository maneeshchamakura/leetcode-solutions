class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((code1, code2) -> {
            int r1 = code1/n, c1=code1%n;
            int r2 = code2/n, c2=code2%n;
            return matrix[r1][c1] - matrix[r2][c2];
        });
        for (int i=0; i<n; i++) {
            int code=i*n;
            queue.add(code);
        }
        int result = -1;
        while (k > 0) {
            int code = queue.poll();
            int r=code/n, c=code%n;
            result = matrix[r][c];
            if (c + 1 < n) {
                int newCode = r*n + (c + 1);
                queue.add(newCode);
            }
            k--;
        }
        return result;
    }
}