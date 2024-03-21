# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def recurse(head, prev):
            if head is None:
                return None
            new_head = recurse(head.next, head)            
            head.next = prev
            if new_head is not None:
                return new_head
            return head
        return recurse(head, None)