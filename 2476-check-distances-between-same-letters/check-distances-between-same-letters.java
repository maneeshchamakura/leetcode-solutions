class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i - map.get(s.charAt(i)) - 1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        for(char c: map.keySet()) {
            int index = c - 'a';
            if (distance[index] != map.get(c)) return false;
        }
        return true;
    }
}