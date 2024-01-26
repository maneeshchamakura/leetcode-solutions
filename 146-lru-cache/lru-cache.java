class LRUCache {
    public int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map;
    static class Node {
        int key, value;
        Node next, prev;
        public Node(int _key, int _value) {
            key = _key;
            value = _value;
            next = prev = null;
        }
    }
    public LRUCache(int _capacity) {
        this.capacity = _capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.value = value;
            insert(node);
        } else if (map.size() < capacity) {
            Node new_node = new Node(key, value);
            insert(new_node);
            map.put(key, new_node);
        } else {
            map.remove(tail.prev.key);
            remove(tail.prev);            
            Node new_node = new Node(key, value);
            insert(new_node);
            map.put(key, new_node);
        }
    }

    public void insert(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.next = head_next;
        node.prev = head;
        head_next.prev = node;     
    }

    public void remove(Node node) {
        Node node_prev = node.prev;
        Node node_next = node.next;
        node_prev.next = node_next;
        node_next.prev = node_prev;
        node.next = node.prev = null;
    }
}

/**
class Node {
    int key, value;
    Node prev, next;
}
Node head  = new Node(0, 0);
Node tail = new Node(0, 0);
head.next = tail;
tail.prev = head

capacity = SIZE

put (key, value) {
    // check if key already exists
    if (map.containsKey(key)) {
        // if already exists
        node = map.get(key)
        remove(node)
        insert(node)
    } else if (map.size() < SIZE) {
        // just add the new key, node pair to the map
        // add the new node in the doubly linked list
        Node new_node = new Node(key, value);
        // add new_node right beside head
        insert(new_node);
        map.put(key, new_node);
    } else {
        remove(tail.prev)
        Node new_node = new Node(key, value);
        insert(new_node);
        map.put(key, new_node)
    }
}

 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */