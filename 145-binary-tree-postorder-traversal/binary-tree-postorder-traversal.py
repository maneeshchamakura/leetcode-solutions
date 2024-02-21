class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack1 = []
        stack2 = []
        stack1.append(root)
        if not root:
            return []
        while stack1:
            curr_node = stack1.pop()
            stack2.append(curr_node)
            if curr_node.left:
                stack1.append(curr_node.left)
            if curr_node.right:
                stack1.append(curr_node.right)
        result = []
        while stack2:
            result.append(stack2.pop().val)
        return result