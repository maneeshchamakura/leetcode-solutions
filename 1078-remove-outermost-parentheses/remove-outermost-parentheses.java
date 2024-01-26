class Solution {
    public String removeOuterParentheses(String S) {
        if (S == null || S.isEmpty()) return S;
        int i=0;
        int n=S.length();
        StringBuilder sb = new StringBuilder("");
        while (i < n) {
            // i points to opening parentheses
            i++;        
            int open=1, close=0;
            while (i < n) {
                if (S.charAt(i) == ')') close++;
                if (S.charAt(i) == '(') open++;
                if (open == close) {
                    i++;
                    break;
                }
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}