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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLength(head);
        int[] sizes = new int[k];
        int end_index, common_size;
        if (k <= len) {
            end_index = k;
            common_size = len/k;
        } else {
            end_index = len;
            common_size = 1;
        }
        // int common_size = len / k;
        for(int i=0; i<end_index; i++) {
            sizes[i] = common_size;
        }
        if (k < len) {
            int rem = len % k;
            int i=0;
            while (rem > 0) {
                sizes[i]++;
                i++;
                rem--;
            }
        }
        System.out.println(Arrays.toString(sizes));
        return splitLinkedListBySizes(head, sizes);
    }
    
    public ListNode[] splitLinkedListBySizes(ListNode head, int[] sizes) {
        ListNode[] result = new ListNode[sizes.length];
        int skip = 0;
        ListNode temp = head;
        for(int i=0; i<sizes.length; i++) {
            int size = sizes[i];
            if (size < 1) {
                result[i] = null;
                break;
            }                      
            ListNode new_head = new ListNode();
            result[i] = new_head;
            while (size-- > 0) {
                new_head.val = temp.val;
                if (size > 0) {
                    new_head.next = new ListNode();
                }
                new_head = new_head.next;
                temp = temp.next;
            }
        }
        return result;
    }
    
    public int getLength(ListNode head){
        int count=0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
}