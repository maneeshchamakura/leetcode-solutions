# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        temp_head = head
        list_nodes = []
        while temp_head is not None:
            list_nodes.append(temp_head)
            temp_head = temp_head.next
        prefix_sum = [0]
        sum_so_far = 0
        sum_dict = {0: 0}
        for i, list_node in enumerate(list_nodes):
            sum_so_far += list_node.val
            prefix_sum.append(sum_so_far)
            if sum_so_far not in sum_dict:
                sum_dict[sum_so_far] = i
        excludes = set()
        for i in reversed(range(1, len(prefix_sum))):
            sub_arr = prefix_sum[:i]
            current_sum = prefix_sum[i]
            if i - 1 in excludes:
                continue
            if current_sum in sub_arr:
                index = sub_arr.index(current_sum)
                # index + 1 to i (exclusive)
                # index to i - 1(exclusive)
                for j in range(index, i):
                    excludes.add(j)
        if len(excludes) == len(list_nodes):
            return None
        head = None
        prev = None
        for i in range(len(list_nodes)):
            if i in excludes:
                continue
            if head == None:
                head = list_nodes[i]
                prev = head
                prev.next = None
            else:
                prev.next = list_nodes[i]
                prev = prev.next
                prev.next = None
        return head





        


