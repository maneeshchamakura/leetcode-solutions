class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return s;
        // remove spaces around the word
        s = s.strip();
        int n = s.length();
        int index = n - 1;
        StringBuffer sb = new StringBuffer("");
        while (index >= 0) {
            // find the first space index from right side
            int i = index;
            while (i >= 0 && s.charAt(i) != ' ') {
                i -= 1;
            }
            // i + 1 is the first non-space character
            // till index
            sb.append(s.substring(i+1, index + 1));
            // ignore all the space characters
            while (i >= 0 && s.charAt(i) == ' ') {
                i -= 1;
            }
            if (i >= 0) {
                sb.append(" ");
            }
            index = i;
        }
        return sb.toString();
    }
}