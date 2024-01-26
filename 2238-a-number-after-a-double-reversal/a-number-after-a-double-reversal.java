class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num < 10) return true;
        String s = num +"";
        return !s.endsWith("0");
    }
}