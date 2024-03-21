# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, node: Optional[ListNode]) -> Optional[ListNode]:
        result = None
        def reverse(head):
            nonlocal result
            if head is None:
                return None
            new_head = reverse(head.next)
            # head.next = None
            if new_head is None:
                result = head
                return head
            print (f"for {head.val} {new_head.val}")
            new_head.next = head
            print (f"returning {new_head.next.val}")
            return new_head.next
        x = reverse(node)
        if x is not None:
            x.next = None
        return result