class Solution {
    // z zero
    // x six
    // g eight
    // w two
    // u four


    // f five
    // v seven
    // i nine
    // n one
    // three

    public String originalDigits(String s) {
        Map<Character, Integer> count_map = new HashMap<>();
        for(char c: s.toCharArray()) {
            int count = count_map.getOrDefault(c, 0);
            count_map.put(c, count + 1);
        }
        String[] arr = {
            "z", "x", "g", "w", "u", "f", "v", "i", "n"
        };
        String[] words = {
            "zero", "six", "eight", "two", "four", "five", "seven", "nine", "one", "three"
        };
        List<Map<Character, Integer>> digits_count_maps = new ArrayList<>();
        for(String digit: words) {
            char[] chars = digit.toCharArray();
            boolean is_valid = true;
            Map<Character, Integer> digit_map = new HashMap<>();
            for(char c: chars) {
                int count = digit_map.getOrDefault(c, 0);
                digit_map.put(c, count + 1);
            }
            digits_count_maps.add(digit_map);
        }        
        int[] nums = {
            0, 6, 8, 2, 4, 5, 7, 9, 1
        };
        List<Character> chars = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            char c = arr[i].charAt(0);
            if (count_map.containsKey(c)) {
                // it can contains any number of times
                int count = count_map.get(c);
                for(int j=0; j<count; j++) {
                    // check for 
                    chars.add((char)(nums[i]+'0'));
                    subtract(count, digits_count_maps.get(i), count_map);
                }                
            }
        }
        // only a chance for three
        if (!count_map.isEmpty()) {
            for(int i=0; i<count_map.get('r'); i++) {
                chars.add('3');
            }
        }
        Collections.sort(chars);
        StringBuffer sb = new StringBuffer("");
        for(char c: chars) sb.append(c);
        return sb.toString();
    }

    public void subtract(int count, Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (char c: map1.keySet()) {
            int new_count = map2.get(c) - map1.get(c);
            if (new_count == 0) {
                map2.remove(c);
            } else {
                map2.put(c, new_count);
            }
        }
    }
}