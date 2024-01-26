class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int maxLen = Math.max(strs1.length, strs2.length);
        int i=0, j=0;
        while(i<maxLen && j<maxLen) {
            int num1 = i<strs1.length ? Integer.parseInt(strs1[i]): 0;
            int num2 = j<strs2.length ? Integer.parseInt(strs2[j]): 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }
}