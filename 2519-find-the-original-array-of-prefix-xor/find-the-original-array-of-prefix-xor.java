class Solution {
    public int[] findArray(int[] pref) {
        int prev_xor = 0;
        int[] ans = new int[pref.length];
        int index = 0;
        for(int elem: pref) {
            int res = prev_xor ^ elem;
            ans[index++] = res;
            prev_xor ^= res;
        }
        return ans;
    }
}