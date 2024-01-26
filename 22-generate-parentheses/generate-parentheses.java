class Solution {
    public List<String> generateParenthesis(int n) {
        if (n < 1) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        create(0, 0, new StringBuilder(""), n, result);
        return result;
    }
    
    public void create(int openCount, int closeCount, StringBuilder sb, int n, List<String> result) {
        if (openCount > n || closeCount > n) return;
        if (openCount == n && closeCount == n) {
            result.add(sb.toString());
            return;
        }
        if (openCount < n) {
            sb.append("(");
            create(openCount + 1, closeCount, sb, n, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closeCount < openCount) {                    
            sb.append(")");
            create(openCount, closeCount+ 1, sb, n, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}