class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            char c = boxes.charAt(i);
            if (c == '0') continue;
            for (int j=0; j<n; j++) {
                int steps = Math.abs(j - i);
                ans[j] += steps;
            }
        }
        return ans;
    }
}