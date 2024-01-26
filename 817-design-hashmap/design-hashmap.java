class MyHashMap {
    int[] elements = new int[1_000_000 + 1];
    public MyHashMap() {
        Arrays.fill(elements, -1);
    }
    
    public void put(int key, int value) {
        this.elements[key] = value;        
    }
    
    public int get(int key) {
        return this.elements[key];
    }
    
    public void remove(int key) {
        this.elements[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */