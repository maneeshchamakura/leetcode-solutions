class MyStack {
    Queue<Integer> queue1, queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() != 1) {
            int i =queue1.poll();
            queue2.add(i);
        }
        int x = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return x;
    }
    
    /** Get the top element. */
    public int top() {
        int x = -1;
        while (queue1.size() > 0) {
            x = queue1.poll();
            queue2.add(x);
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return x;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */