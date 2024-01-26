class Solution {
    public int compareVersion(String version1, String version2) {
        int[] parts1 = Arrays.stream(version1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] parts2 = Arrays.stream(version2.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int n = parts1.length;
        int m = parts2.length;
        System.out.println(n + "," + m);
        for (int i=0; i<Math.min(n, m); i++) {
            int val1 = parts1[i], val2 = parts2[i];
            if (val1 < val2) return -1;
            if (val1 > val2) return 1;
        }
        if (n != m) {
            if (n > m) {
                for (int i=m; i < n; i++) {
                    if (parts1[i] == 0) continue;
                    return 1;
                }
                return 0;
            } else {
                for (int i=n; i<m; i++) {
                    if (parts2[i] == 0) continue;
                    return -1;
                }
                return 0;
            }
        }
        return 0;
    }
}