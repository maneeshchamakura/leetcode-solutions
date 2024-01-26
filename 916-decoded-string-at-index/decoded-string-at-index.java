class Solution {
    public String decodeAtIndex(String s, int k) {
        return find_char(s, k);
    }

    public String find_char(String s, long k) {
        long count = 0;
        for(char c: s.toCharArray()) {
            if (!Character.isDigit(c)) {
                count++;
                if (count == k) {
                    return c+"";
                }
            } else {
                long updated_len = count*(Integer.parseInt(c+""));
                if (k > count && k <= updated_len) {
                    // between the bounds
                    long mod = k % count;
                    if (mod == 0) return find_char(s, count);
                    return find_char(s, mod);
                }
                count = updated_len;
            }
        }
        return "";
    }
}