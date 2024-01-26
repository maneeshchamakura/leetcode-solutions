/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node newHead = createLinkedList(head);
        Map<Node, Node> map = new HashMap<>();
        Node temp1 = head, temp2 = newHead;
        while (temp1 != null && temp2 != null) {
            map.put(temp1, temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        // copy the random pointers
        temp1= head;
        while (temp1 != null) {
            Node random = temp1.random;
            map.get(temp1).random = map.get(random);
            temp1 = temp1.next;
        }
        return newHead;
    }
    public Node createLinkedList(Node head) {
        if (head == null) return head;
        Node dummy = new Node(-1);
        dummy.next = null;
        Node startNode = dummy;
        while (head != null) {
            dummy.next = new Node(head.val);
            dummy = dummy.next;
            head = head.next;
        }
        return startNode.next;
    }
}