/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        ListNode final_start = start;
        int len = length(head);
        int pos = len - n + 1;
        ListNode temp = head;
        while (pos-- > 1) {
            start.next = temp;
            start = start.next;
            temp = temp.next;
        }
        start.next = temp.next;
        return final_start.next;
    }
    public int length(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}