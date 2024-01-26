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
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        //int len = length(head);
        if (head.next == null) return true;
        if (head.next.next == null) return (head.val == head.next.val);
        
        /*
        * Find the middle node and it's previous node
        * For linkedlists of odd length slow will point to middle node
        * For linkedlist of even length it will point to the (n/2)+1 th element 
        * For ex for 1->2->2->1
        * slow pointer will point to second 2
        */
        ListNode prev=null, slow=head, fast=head;
        boolean result = false;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        if(fast == null) {
            /*
            * If the list is 1->2->3->4->4->3->2->1
            * Point the last node in the first half to null
            * First Half: 1->2->3->4-> null 
            * Reverse the second half of the list 
            * Second Half: null<-4<-3<-2<-1 
            * compare the two halfs and restore the list
            */
            prev.next = null;
            ListNode newHead = reverse(slow);
            if (compare(head, newHead)) {
                result = true;
            }
            // restore the linked list
            prev.next = reverse(newHead);
        } else {
            /*
            * If the list is 1->2->3->4->5->4->3->2->1
            * Ignore the middle element
            * Point the last node in the first half to null
            * First Half: 1->2->3->4-> null 
            * reverse the second half of the list
            * Second Half: null<-4<-3<-2<-1 
            * compare the two halfs and restore the list
            */
            prev.next = null;
            ListNode newHead = reverse(slow.next);
            if (compare(head, newHead)) {
                result = true;
            }
            // restore the linked list
            prev.next = slow;
            reverse(newHead);
        }
        // uncomment the below line to see whether linkedlist is restored
        // System.out.println(getLinkedListAsString(head));
        return result;
    }
    public String getLinkedListAsString(ListNode head) {        
        StringBuffer sb = new StringBuffer("");
        while(head != null) {
            sb.append(head.val);
            if(head.next != null) sb.append("->");
            head = head.next;
        }
        return sb.toString();
    }
    public boolean compare(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return (head1 == null && head2 == null);
    }
    public int length (ListNode head) {
        int count = 0;
        while (head != null) {
            count += 1;
            head = head.next;
        }
        return count;
    }
    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}