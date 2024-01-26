class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        /*char[] chararray1 = s1.toCharArray();
        char[] chararray2 = s2.toCharArray();
        Arrays.sort(chararray1);
        Arrays.sort(chararray2);
        // compare s1 & s2
        int n = s1.length();
        int i;
        for (i=0; i<n; i++) {
            char c1 = chararray1[i];
            char c2 = chararray2[i];
            if (c1 > c2) break;
        }
        if (i == n) return true;
        // compare s2 & s2 
        for (i=0; i<n; i++) {
            char c1 = chararray2[i];
            char c2 = chararray1[i];
            if (c1 > c2) return false;
        }
        return true;*/
        int[] count1= new int[26];
        int[] count2 = new int[26];
        int n = s1.length();
        for (int i=0; i<n; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        boolean first_1 = false, first_2 = false;
        int x=0, y=0;
        for (int i=0; i<26; i++) {
            x += count1[i];
            y += count2[i];
            if (x > y) {
                if (first_2) return false;
                first_1 = true;
            } else if (y > x) {
                if (first_1) return false;
                first_2 = true;
            }
        }
        return true;
    }
}