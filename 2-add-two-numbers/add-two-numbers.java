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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1 = (l1 == null) ? l2: l1;
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            l1 = l1.next;
        }
        if (carry == 1) {
            dummy.next = new ListNode(1);
            dummy = dummy.next;
        }
        return head.next;
    }   
}