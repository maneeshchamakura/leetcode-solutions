class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) return true;
        int len = words.length;
        for (int i=0; i<len; i++) {
            if (i > 0) {
                String s1 = words[i-1];
                String s2 = words[i];
                if(!isIncreasing(s1, s2, order)) {
                    return  false;
                }
            }
        }
        return true;
    }
    public boolean isIncreasing(String a, String b, String order) {
        int[] pos = new int[26];
        for (int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            pos[c-'a'] = i+1;
        }
        int i1=0,i2=0;
        int len1=a.length(), len2=b.length();
        while(i1<len1 || i2<len2) {
            if (i1 == len1 || i2 == len2) {
                if (i1 == len1) return true;
                if (i2 == len2) return false;
            }
            char c1= a.charAt(i1);
            char c2 = b.charAt(i2);
            if (pos[c1-'a'] > pos[c2 - 'a']) return false;
            if (pos[c1 - 'a'] < pos[c2 - 'a']) return true;
            i1++;
            i2++;
        }
        return true;
    }
}