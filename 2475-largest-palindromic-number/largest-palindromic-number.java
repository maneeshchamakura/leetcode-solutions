class Solution {
    public String largestPalindromic(String num) {
        Map<Character, Integer> count_map = new HashMap<>();
        for(char c: num.toCharArray()) {
            count_map.computeIfAbsent(c, k -> 0);
            int count = count_map.get(c) + 1;
            count_map.put(c, count);
        }
        StringBuilder sb = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        for(char c='9'; c >= '1'; c--) {
            int count = count_map.getOrDefault(c, 0);
            if (count > 0 && count >= 2) {
                int quot = count/2;
                while(quot-- > 0) {
                    sb.append(c);
                    sb2.append(c);
                }
                if (count % 2 == 0) count_map.remove(c);
                else count_map.put(c, 1);
            }
        }
        // add zeros if possible
        int count = count_map.getOrDefault('0', 0);
        if (count > 1 && sb.length() > 0) {
            int quot = count/2;
            while(quot-- > 0) {
                sb.append('0');
                sb2.append('0');
            }
            if (count % 2 == 0) count_map.remove('0');
            else count_map.put('0', 1);
        }
        // add the biggest remaining char in between
        for(char c = '9'; c >= '0'; c--) {
            count = count_map.getOrDefault(c, 0);
            if (count >= 1) {
                sb.append(c);
                break;
            }
        }
        return sb.toString() + sb2.reverse().toString();
    }
}