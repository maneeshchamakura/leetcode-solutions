# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        temp = head
        length = 0
        while temp is not None:
            temp = temp.next
            length += 1
        if length < 3:
            return
        temp = head
        for _ in range(length // 2):
            temp = temp.next
        right_most = None if length % 2 == 0 else temp
        if length % 2 == 1:
            temp = temp.next
        right_pointer = temp
        if right_most is not None:
            right_most.next = None
        def recurse(link_head, i, count):
            nonlocal right_pointer, right_most
            if i > count:
                return
            recurse(link_head.next, i + 1, count)
            link_head.next = right_pointer
            next_right = right_pointer.next
            right_pointer.next = right_most
            right_pointer = next_right
            right_most = link_head
        recurse(head, 1, length // 2)
        return

            
            
            
