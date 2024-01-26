class Solution {
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";
        List<Character> alist = new ArrayList<>();
        StringBuffer result = new StringBuffer();
        for (int i=0; i<n; i++) {
            alist.add((char)(i+'1'));
        }
        backtrack(result, alist, n, k);
        return result.toString();
    }

    public int fact(int n) {
        int res = 1;
        for (int i=1; i<=n; i++) res *= i;
        return res;
    }

    public void backtrack(StringBuffer result, List<Character> alist, int n, int k) {
        if (n == 2) {
            if (k == 1) {
                result.append(alist.get(0));
                result.append(alist.get(1));
            } else {
                result.append(alist.get(1));
                result.append(alist.get(0));
            }
            return;
        }
        int block_size = fact(n-1);
        double block_d = k+0.0;
        block_d /= block_size;
        block_d = Math.ceil(block_d);
        int block = (int) block_d;
        result.append(alist.get(block-1));
        alist.remove(block-1);
        int new_k = k - (block_size * (block-1));
        backtrack(result, alist, n-1, new_k);
    }
}