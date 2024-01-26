public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = get_length(headA);
        int len2 = get_length(headB);
        if (len1 > len2) {
            // move the head to cover the difference
            int diff = len1 - len2;
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else if (len2 > len1) {
            int diff = len2 - len1;
            while (diff-- > 0) {
                headB = headB.next;
            }
        }
        while ((headA != null && headB != null) && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        if (Objects.isNull(headA) || Objects.isNull(headB)) return null;
        return headA;
    }
    public int get_length(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;        
    }
}