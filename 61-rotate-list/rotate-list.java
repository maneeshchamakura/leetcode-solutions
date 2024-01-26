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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        if (head.next == null) return head;
        int len = length(head);
        k = k % (len);
        if (k == 0) return head;
        ListNode prev = null, current = head;
        for (int i=1; i <= len - k; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        ListNode newHead = current;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        return newHead;
    }
    public int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}