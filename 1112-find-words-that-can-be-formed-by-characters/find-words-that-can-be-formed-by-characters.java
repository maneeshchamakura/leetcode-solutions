class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: chars.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int result = 0;
        for (String word: words) {
            // make a Map which stores character counts
            Map<Character, Integer> temp = new HashMap<>();
            for (char c: word.toCharArray()) {
                if (temp.containsKey(c)) {
                    temp.put(c, temp.get(c) + 1);
                } else {
                    temp.put(c, 1);
                }
            }
            boolean isValid = true;
            // compare both maps to see if each char count of temp is less than or
            // equal to the original map
            for (char c: temp.keySet()) {
                int count1 = temp.get(c);
                int count2 = map.getOrDefault(c, 0);
                if (count1 > count2) {
                    isValid = false; break;
                }
            }
            if (isValid) result += word.length();
        }
        return result;
    }
}