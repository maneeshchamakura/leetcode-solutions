class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int len = s.length();
        int index = 0;
        for (int i=0; i<words.length; i++) {
            for(char c: words[i].toCharArray()) {
                if (index == len) return false;
                if (s.charAt(index) != c) return false;
                index++;         
            }
            if (index == len) return true;
        }
        return false;
    }
}