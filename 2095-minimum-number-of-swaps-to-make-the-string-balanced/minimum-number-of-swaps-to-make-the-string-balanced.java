class Solution {
    public int minSwaps(String s) {
        if (is_balanced(s)) return 0;
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c: s.toCharArray()) {
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() == ']') {
                    count++;
                    stack.push(c);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        
        return (stack.size()/4) + (stack.size()%4 == 2? 1 : 0);
    }
    
    public boolean is_balanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty() || c == '[') {
                stack.push(c);
            } else {
                if (stack.pop() == '[') continue;
                return false;
            }
        }
        return stack.isEmpty();
    }
}