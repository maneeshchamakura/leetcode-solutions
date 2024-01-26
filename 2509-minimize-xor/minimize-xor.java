class Solution {
    public int minimizeXor(int num1, int num2) {
        String s = Integer.toBinaryString(num2);
        int set_bits = 0;
        for(char c: s.toCharArray()) {
            if (c == '1') set_bits++;
        }
        String num1_bin = Integer.toBinaryString(num1);
        char[] x = new char[num1_bin.length()];
        Arrays.fill(x, '0');
        int count = 0;
        for(int i=0; i < num1_bin.length(); i++) {
            if (num1_bin.charAt(i) == '0') continue;
            x[i] = '1';
            count++;
            if (count == set_bits) break;
        }
        if (count < set_bits) {
            // fil the char array
            for (int i=x.length-1; i >= 0; i--) {
                if(x[i] == '1') continue;
                x[i] = '1';
                count++;
                if (count == set_bits) break;
            }
            if (count < set_bits) {
                StringBuilder sb = new StringBuilder("");
                int rem = set_bits - count;
                while(rem-- > 0) {
                    sb.append('1');
                }
                return Integer.parseInt(sb.toString() + new String(x), 2);
            }
        }
        return Integer.parseInt(new String(x), 2);
    }
}