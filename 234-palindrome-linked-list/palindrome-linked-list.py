# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        length = 0
        temp = head
        while temp is not None:
            length += 1
            temp = temp.next
        temp = head
        for i in range(length // 2):
            temp = temp.next
        left_length = math.ceil(length / 2)
        right_length = length - left_length
        if length % 2 == 1:
            left_length -= 1
        # find the right most node
        left_start = head        
        def reverse(head, prev):
            if head is None:
                return None
            new_head = reverse(head.next, head)            
            head.next = prev
            if new_head is not None:
                return new_head
            return head
        # reverse the right start node
        right_start = reverse(temp, None)
        for i in range(left_length):
            if left_start.val == right_start.val:
                left_start = left_start.next
                right_start = right_start.next
                continue
            return False
        return True