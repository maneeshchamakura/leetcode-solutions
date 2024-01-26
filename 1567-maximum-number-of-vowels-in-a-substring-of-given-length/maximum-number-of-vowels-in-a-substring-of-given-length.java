class Solution {

    public boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    public int maxVowels(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        if (len < k) return 0;
        int max = 0;
        int start = 0, end = 0;
        int vowel_count = 0;
        while(end < len) {
            char c = s.charAt(end);
            if (isVowel(c)) {
                vowel_count++;
            }
            map.put(c, map.getOrDefault(c,0) + 1);
            if (end - start + 1 == k) {
                max = Math.max(max, vowel_count);
                // increment the start and remove the start char from map
                char temp = s.charAt(start);
                if (isVowel(temp)) vowel_count--;
                int count = map.get(temp);
                if (count > 1) {
                    map.put(temp, map.get(temp) - 1);
                } else {
                    map.remove(temp);
                }
                start++;
            }
            end++;
        }
        return max;
    }

}