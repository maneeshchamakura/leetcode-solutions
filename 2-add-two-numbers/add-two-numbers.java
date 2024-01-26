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
        ListNode head = new ListNode(l1.val + l2.val);
        ListNode temp = head;
        l1 = l1.next; l2=l2.next;
        while (l1 != null || l2 != null) {
            int sum = ((l1 == null)?0: l1.val) + ((l2 == null) ? 0: l2.val);
            temp.next = new ListNode(sum, null);
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        temp = head;
        int carry=0;
        ListNode prev = temp;
        while(temp != null) {
            prev = temp;
            int sum = temp.val + carry;
            temp.val = sum%10;
            carry = sum/10;
            temp = temp.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        return head;
    }
}