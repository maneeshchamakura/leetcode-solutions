class Solution {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] result = new int[num + 1];        
        for (int i=1; i < result.length; i++) {
            result[i] = (i & 1) + result[i/2];
        }
        return result;
    }
}