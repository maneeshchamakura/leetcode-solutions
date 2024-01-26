class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    public MyStack() {
    }
    
    public void push(int x) {
        // push to queue1
        queue1.add(x);
    }
    
    public int pop() {
        int val  = -1;
        int size = queue1.size();
        if (size == 1) {
            // there is only one node in the linked list
            return queue1.remove();
        }
        // remove size - 1 elements
        // and add the into the same queue1
        for (int i=1; i<= size - 1; i++) {
            val = queue1.remove();
            queue1.add(val);
        }
        val = queue1.remove();
        return val;
    }
    
    public int top() {
        int val = -1;
        int size = queue1.size();
        for (int i=1; i <= size; i++) {
            val  = queue1.remove();
            queue1.add(val);
        }
        return val;
    }
    
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