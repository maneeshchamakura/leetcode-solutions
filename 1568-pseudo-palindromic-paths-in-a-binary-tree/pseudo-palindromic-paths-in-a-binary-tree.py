# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pseudoPalindromicPaths (self, root: Optional[TreeNode]) -> int:
        if root.left == None and root.right == None:
            return 1
        ans = [0]

        def is_palindrome(count_dict):
            found_extra = False
            # print(count_dict)
            for value in count_dict.values():
                if value > 0:
                    if value % 2 == 1:
                        if found_extra:
                            return False
                        found_extra = True
            return True

        def propagate(root, prev_dict, ans, root_node):
            if root == None:
                return
            prev_dict[root.val] += 1
            if(root!= root_node and is_palindrome(prev_dict) and root.left == None and root.right == None):
                ans[0] += 1
            propagate(root.left, prev_dict, ans, root_node)
            propagate(root.right, prev_dict, ans, root_node)
            prev_dict[root.val] -= 1
        propagate(root, defaultdict(int), ans, root)
        return ans[0]
            
