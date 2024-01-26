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
        int n = len(head);
        if (head == null || n == 0) return head;
        k = k % n;
        if (k == 0) return head;
        ListNode dummyHead = new ListNode();
        ListNode temp = head;
        int left_len = n - k;
        while (left_len-- > 1) {
            temp = temp.next;
        } 
        // now left_len is pointing last node in the first half
        ListNode right_half = temp.next;
        // set the next node to null
        temp.next = null;
        ListNode new_head = right_half;
        while(right_half.next != null) {
            right_half = right_half.next;
        }
        right_half.next = head;
        return new_head;
    }

    public int len(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
}