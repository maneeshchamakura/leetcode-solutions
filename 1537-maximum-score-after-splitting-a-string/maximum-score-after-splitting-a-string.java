class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zero_count = new int[n];
        int[] one_count = new int[n];
        // left zero count
        int zero_so_far = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            zero_so_far += (c == '0' ? 1: 0);
            zero_count[i] = zero_so_far;
        }
        // right one count
        int one_so_far = 0;
        for(int i=n-1; i >= 0; i--) {
            char c = s.charAt(i);
            one_so_far += (c == '1' ? 1: 0);
            one_count[i] = one_so_far;
        }
        int res = 0;
        for (int i=0; i<n-1; i++) {
            res = Math.max(res, zero_count[i] + one_count[i+1]);
        }
        return res;
    }
}