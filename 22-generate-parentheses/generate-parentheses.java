class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        generate("", result, 0, 0, n);
        return result;
    }
    
    public void generate(String soFar, List<String> result, int open, int close, int max) {
        if (open > max || close > max) return;
        if (open == max && close == max) {
            result.add(soFar);
            return;
        }
        if (open > close) {
            generate(soFar+")", result, open, close+1, max);
        }
        if (open < max) {
            generate(soFar+"(", result, open+1, close, max);
        }
    }
}