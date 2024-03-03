# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        def go_next(current_node):
            if current_node is None:
                return 0
            sub_ans = go_next(current_node.next)
            if sub_ans == n:
                current_node.next = current_node.next.next
            return 1 + sub_ans
        go_next(dummy)
        return dummy.next