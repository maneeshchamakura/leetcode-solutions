/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // iterate one node at 1x speed and other at 2x speed
        // if they meet there is a cycle
        if (Objects.isNull(head) || Objects.isNull(head.next)) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = Objects.isNull(fast.next) ? null : fast.next.next;
            if (slow == fast) break;
        }
        return slow == fast;
    }
}