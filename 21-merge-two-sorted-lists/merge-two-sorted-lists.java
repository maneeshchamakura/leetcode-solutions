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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result_head = null;
        if (Objects.isNull(list1)) return list2;
        if (Objects.isNull(list2)) return list1;
        ListNode final_node = null;
        if (list1.val <= list2.val) {
            result_head = list1;
            list1 = list1.next;
        } else {
            result_head = list2;
            list2 = list2.next;
        }
        result_head.next = null;
        final_node = result_head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result_head.next = list1;
                list1 = list1.next;
            } else {
                result_head.next = list2;
                list2 = list2.next;
            }
            result_head = result_head.next;
        }
        // check if list1 is not empty
        if (list1 != null) {
            result_head.next = list1;
        }
        // check if list2 is not empty
        if (list2 != null) {
            result_head.next = list2;
        }
        return final_node;
    }
}