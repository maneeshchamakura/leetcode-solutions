class Solution {
    public String countAndSay(int n) {
        return recurse(n);
    }

    public String recurse(int n) {
        if (n == 1) return "1";
        String temp = recurse(n-1);
        // for "11" answer should be "21"
        // for "21" answer should be "1211"
        StringBuffer sb = new StringBuffer("");
        int len = temp.length();
        int index = 0;
        while (index < len) {
            int count = 0;
            char c = temp.charAt(index);
            while (index < len && c == temp.charAt(index)) {
                count++;
                index++;
            }
            sb.append(count+"");
            sb.append(c+"");
        }
        return sb.toString();
    }
}