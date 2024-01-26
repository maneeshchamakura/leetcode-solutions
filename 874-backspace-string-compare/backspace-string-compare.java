class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        // add all the characters to the string s
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }

        Stack<Character> stack2 = new Stack<>();
        // add all the characters from the string t
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int val1 = stack1.pop();
            int val2 = stack2.pop();
            if (val1 != val2) return false;
        }

        return stack1.isEmpty() == stack2.isEmpty();
    }
}