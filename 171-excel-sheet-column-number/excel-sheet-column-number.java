class Solution {
    public int titleToNumber(String columnTitle) {
        int i = columnTitle.length() - 1;
        int mul = 1;
        int res = 0;
        while (i >= 0) {
            res += mul* (columnTitle.charAt(i) - 'A' + 1);
            mul *= 26;
            i--;
        }
        return res;
    }
}