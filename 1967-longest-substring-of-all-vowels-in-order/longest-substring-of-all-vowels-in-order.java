class Solution {
    public int longestBeautifulSubstring(String word) {
        if (word == null || word.length() == 0) return 0;
        int result = 0, index=0;
        int n = word.length();
        while (index < n) {
            char c = word.charAt(index);
            if (c != 'a') {
                index++;
                continue;
            }
            char prev = 'a';
            int start = index;
            // now this is a
            while (index < n) {
                // go till the conditions are valid
                char temp = word.charAt(index);
                if (isVowel(temp) && isValidOrder(prev, temp)) {
                    if (temp == 'u') {
                        result = Math.max(result, index - start + 1);
                    }
                    index++;
                    prev = temp;
                } else {
                    break;
                }
            }
        }
        return result;
    }
    public boolean isVowel(char c) {
        return c =='a' || c =='e' || c == 'i' || c == 'o' || c == 'u';
    }
    public boolean isValidOrder(char c1, char c2) {
        if (c2 == c1) return true;
        switch(c1) {
            case 'a': return c2 == 'e';
            case 'e': return c2 == 'i';
            case 'i': return c2 == 'o';
            case 'o': return c2 == 'u';
            default:
                return false;
        }
    }
}