class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for(int[] subarr: memo) Arrays.fill(subarr, -1);
        return dfs(text1, text2, 0, 0, new StringBuffer(""), new StringBuffer(""), memo);
    }

    public int dfs(String s1, String s2, int index1, int index2, StringBuffer sb1, StringBuffer sb2, int[][] memo) {
        if (memo[index1][index2] != -1) return memo[index1][index2];
        // base case here
        if (index1 == s1.length() || index2 == s2.length()) {
            return 0;
        }
        int result = 0;
        char c1 = s1.charAt(index1);
        char c2 = s2.charAt(index2);
        if (c1 == c2) {
            sb1.append(c1); sb2.append(c2);
            int val = dfs(s1, s2, index1 + 1, index2 + 1, sb1, sb2, memo);
            sb1.deleteCharAt(sb1.length() - 1);
            sb2.deleteCharAt(sb2.length() - 1);
            result = 1 + val;
        } else {
            // include the char from s1
            sb1.append(c1);
            int val1 = dfs(s1, s2, index1+1, index2, sb1, sb2, memo);
            sb1.deleteCharAt(sb1.length() - 1);
            sb2.append(c2);
            int val2 = dfs(s1, s2, index1, index2 + 1, sb1, sb2, memo);
            sb2.deleteCharAt(sb2.length() - 1);
            result = Math.max(val1, val2);
        }
        memo[index1][index2] = result;
        return result;
    }
}