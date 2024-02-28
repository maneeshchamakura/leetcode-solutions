class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        self.max_ans = float("-inf")
        def traverse(current_node):
            if current_node is None:
                return (True, None, None, 0)
            left_bst, left_lowest, left_highest, left_sum = traverse(current_node.left)
            right_bst, right_lowest, right_highest, right_sum = traverse(current_node.right)
            current_val = current_node.val
            if left_bst and right_bst:
                left_valid = False
                if left_highest is None:
                    left_valid = True
                else:
                    left_valid = current_val > left_highest
                right_valid = False
                if right_lowest is None:
                    right_valid = True
                else:
                    right_valid = current_val < right_lowest
                is_bst = left_valid and right_valid
                if is_bst:
                    subtree_sum = current_val + left_sum + right_sum
                    self.max_ans = max(self.max_ans, subtree_sum)
                    next_lowest_possible, next_highest_possible = current_val, current_val
                    if left_lowest is not None:
                        next_lowest_possible = left_lowest
                    if right_highest is not None:
                        next_highest_possible = right_highest
                    return (True, next_lowest_possible, next_highest_possible, subtree_sum)
                return (False, None, None, 0)
            return (False, None, None, None)
        traverse(root)
        return 0 if self.max_ans < 0 else self.max_ans

            
            