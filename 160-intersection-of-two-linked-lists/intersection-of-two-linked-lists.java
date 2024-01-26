/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headB != null) {
            set.add(headB);
            headB = headB.next;
        }
        while (headA != null) {
            if (set.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}