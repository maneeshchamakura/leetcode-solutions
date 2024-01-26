class Solution {
    public static int prime = 101;

    public int repeatedStringMatch(String s, String b) {
        StringBuffer sb = new StringBuffer("");
        sb.append(s);
        int count = 1;
        while (sb.length() < b.length()) {
            sb.append(s);            
            count++;
        }
        boolean valid = is_substring(sb.toString(), b);
        if (valid) return count;
        // add s to sb
        sb.append(s);
        System.out.println("i am here");
        if (is_substring(sb.toString(), b)) return count + 1;
        return -1;
    }

    public boolean is_substring(String s, String t) {
        int n = s.length();
        int m = t.length();
        long hash = createHash(s, m-1);
        long pattern_hash = createHash(t, m-1);
        for (int i=1 ; i <= n - m + 1; i++) {
            if (pattern_hash == hash && t.equals(s.substring(i-1, i+m-1))) return true;
            if (i < n - m + 1) {
                hash = recalculate_hash(hash, i-1, i + m - 1, s, m);
            }
        }
        return false;
    }

    long createHash(String s, int end) {
        long hash = 0L;
        for (int i=0; i<=end; i++) {
            hash += s.charAt(i)*Math.pow(prime, i);
        }
        return hash;
    }

    long recalculate_hash(long hash, int oldIndex, int newIndex, String s, int m) {
        long  new_hash = hash - s.charAt(oldIndex);
        new_hash /= prime;
        new_hash += s.charAt(newIndex)*Math.pow(prime, m - 1);
        return new_hash;
    }
}