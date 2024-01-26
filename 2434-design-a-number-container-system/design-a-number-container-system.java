class NumberContainers {

    Map<Integer, PriorityQueue<Integer>> numToIndex;
    Map<Integer, Integer> indexToNum;
    public NumberContainers() {
        numToIndex = new HashMap<>();
        indexToNum = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (!numToIndex.containsKey(number)){
            numToIndex.put(number, new PriorityQueue<Integer>());
        }
        numToIndex.get(number).add(index);
        indexToNum.put(index, number);
    }
    
    public int find(int number) {
        if (!numToIndex.containsKey(number)) return -1;
        PriorityQueue<Integer> heap = numToIndex.get(number);
        while (heap.size() != 0) {
            int index = heap.peek();
            if (number == indexToNum.get(index)) {
                return index;
            }
            // means the element is not present in the heap or got replaced
            heap.poll();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */