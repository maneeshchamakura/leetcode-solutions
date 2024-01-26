class Solution {
    public int trailingZeroes(int n) {
        // find the number of 5's
        return find_5s(n);
    }
    public int find_5s(int n) {
        int res = n/5;
        if (res == 0) return res;
        return res + find_5s(res);
    }
}