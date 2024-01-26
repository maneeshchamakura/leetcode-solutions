class Solution {
    class Pair {
        int count;
        char c;
        Pair(char c) {
            this.c = c;
            this.count =0;
        }
    }
    
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) return s;
        List<Pair> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                list.get(map.get(c)).count++;
            } else {
                int index = list.size();
                Pair p = new Pair(c);
                p.count++;
                map.put(c, index);
                list.add(p);
            }
        }
        Collections.sort(list, (a, b) -> b.count - a.count);
        StringBuilder sb = new StringBuilder("");
        for (Pair p: list) {
            int count = p.count;
            while (count > 0) {
                sb.append(p.c);
                count--;
            }
        }
        return sb.toString();
    }
}