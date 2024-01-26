class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int prev = 0;
        // int i=0;
        for(int i=0; i<s.length(); i++) {
            char c= s.charAt(i);
            int value = map.get(c);
            if (value == 1 || value == 10 || value == 100) {
                if (i+1 < s.length() ) {
                    char next_char = s.charAt(i+1);
                    if (value == 1) {                        
                        if (next_char == 'V' || next_char == 'X') {
                            value = map.get(next_char) - value;
                        } else {
                            i--;
                        }
                    } else if (value == 10) {
                        if (next_char == 'C' || next_char == 'L') {
                            value = map.get(next_char) - value;
                        } else {
                            i--;
                        }
                    } else {
                        if (next_char == 'D' || next_char == 'M') {
                            value = map.get(next_char) - value;
                        } else {
                            i--;
                        }
                    }
                    i++;
                }
            }
            result += value;
        }
        return result;
    }
}