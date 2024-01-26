class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode temp = head; ListNode prev = null;
        int i=0;
        while (temp != null && i < k) {
            i++;
            prev = temp;
            temp = temp.next;
        }
        if (i == k) {
            // all nodes are there
            if (prev != null)  {
                prev.next = null;
            }
            ListNode new_head = reverse(head);
            ListNode next_head = reverseKGroup(temp, k);           
            ListNode last_node = new_head;
            while (last_node.next != null) {
                last_node = last_node.next;
            }
            last_node.next = next_head;
            return new_head;
        }
        return head;
    }

    public ListNode reverse(ListNode node) {
        ListNode temp = node, prev = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;            
        }
        return prev;
    }
}