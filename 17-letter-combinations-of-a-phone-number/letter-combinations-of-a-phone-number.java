class Solution {
    String[][] strings = {
        {"a", "b", "c"},
        {"d", "e", "f"},
        {"g", "h", "i"},
        {"j", "k", "l"},
        {"m", "n", "o"},
        {"p", "q", "r", "s"},
        {"t", "u", "v"},
        {"w", "x", "y", "z"}
    };
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();     
        int n = digits.length();
        result = Arrays.asList(strings[digits.charAt(n-1) - '2']);
        for (int i=n-2; i >= 0; i--) {
            int index = digits.charAt(i) -  '2';
            String[] currentStrings = strings[index];
            List<String> temp2 = new ArrayList<>();
            for (String str: currentStrings) {
                for (String s: result) {
                    temp2.add(str+s);
                }
            }
            result = temp2;
        }
        return result;
    }
    public List<String> recurse(String digits, int i) {
        if (i == digits.length()-1) {
            int index = digits.charAt(i) - '2';
            return Arrays.asList(strings[index]);
        }
        List<String> temp = recurse(digits, i+1);
        int current = digits.charAt(i) - '2';
        List<String> result = new ArrayList<>();
        for(String s: strings[current]) {
            for (String str: temp) {
                result.add(s+str);
            }
        }
        return result;
    }
}