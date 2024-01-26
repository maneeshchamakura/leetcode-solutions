class Solution {
    public String reverseVowels(String s) {
        if (s.isEmpty()) return s;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0, end = chars.length - 1;
        while (start < end) {
           // go till you find the first vowel
           while (start < end && !is_vowel(chars[start])) {               
               start++;
           }
           // go towards left till you find the vowel
           while (start < end && !is_vowel(chars[end])) {
               end--;
           }
           if (start < end) {
               // swap start and end chars
               char temp = chars[start];
               chars[start] = chars[end];
               chars[end] = temp;
               start++;
               end--;
           }
        }
        return new String(chars);
    }

    public boolean is_vowel(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e'  || c == 'i' || c == 'o' || c == 'u');
    }
}