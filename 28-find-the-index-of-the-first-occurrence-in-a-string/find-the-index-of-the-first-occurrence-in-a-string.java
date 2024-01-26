class Solution {
    private static final int p = 31;
    private static final int mod = 997;
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;
        if (needle.length() > haystack.length()) return -1;
        int m = needle.length();
        int mf = 1;
        for (int i=1; i<m; i++) {
            mf = (mf * p)%mod;
        }
        int needleHash = hash(needle, 0, m);
        int hash = hash(haystack, 0, m);
        for (int i=m; i<=haystack.length(); i++) {
            if (needleHash == hash && needle.equals(haystack.substring(i-m, i))) {
                return i-m;
            }
            if (i < haystack.length()) {
                hash  = (hash + mod - (mf * haystack.charAt(i-m)%mod))%mod;
                hash = (hash*p + haystack.charAt(i))%mod;   
            }            
        }
        return -1;
    }
    public int hash(String s, int from, int to) {
        int hash = 0;
        for (int i=from; i<to; i++) {
            hash = ((hash * p)% mod + s.charAt(i))%mod;
        }
        return hash;
    }
}