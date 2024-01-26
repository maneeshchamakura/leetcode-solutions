class Solution {
    public String robotWithString(String s) {
        // PriorityQueue
        // a-z 0-25
        PriorityQueue<int[]> right_heap = new PriorityQueue<>((a, b) -> {
            return a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]);
        });
        Stack<Integer> stack = new Stack<>();
        Map<Integer, int[]> index_to_arr = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            int[] arr = new int[]{pos, i};
            right_heap.offer(arr);
            index_to_arr.put(i, arr);
        }
        // System.out.println(right_heap);
        StringBuilder sb = new StringBuilder("");
        // add all chars to min_heap
        int prev = -1;
        while(!right_heap.isEmpty()) {
            // compare stack top to the heap peek            
            // find the heap min
            // keep removing values less than prev
            while(!right_heap.isEmpty() && right_heap.peek()[1] <= prev) right_heap.poll();
            if (right_heap.isEmpty()) break;
            while(!stack.isEmpty()) {
                int stack_top = stack.peek();
                int heap_peek = right_heap.peek()[0];
                if (stack_top <= heap_peek) {
                    sb.append((char)(stack.pop() + 'a'));
                } else {
                    break;
                }
            }
            int[] peek = right_heap.poll();
            for (int start = prev + 1; start < s.length() && start < peek[1]; start++) {
                stack.push(s.charAt(start)-'a');
                // right_heap.remove(index_to_arr.get(start));
            }            
            prev = peek[1];
            // add the current char to result
            sb.append((char)(peek[0] + 'a'));
            // System.out.println(right_heap);
            // System.out.println(sb.toString());
        }
        while(!stack.isEmpty()) {
            sb.append((char)(stack.pop() + 'a'));
        }
        return sb.toString();
    }
}