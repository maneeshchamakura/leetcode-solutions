/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            List<TreeNode> next_level = new ArrayList<>();
            // poll size times
            while(size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                // add the left node 
                next_level.add(temp.left);
                if (temp.right != null)
                // add the right node
                next_level.add(temp.right);
            }
            if (level % 2 == 1 && next_level.size() > 0) {
                // reverse the values in this node
                int low = 0, high = next_level.size()-1;
                while(low < high) {
                    int val1 = next_level.get(low).val;
                    int val2 = next_level.get(high).val;
                    next_level.get(low).val = val2;
                    next_level.get(high).val = val1;
                    low++;
                    high--;
                }                
            }
            // add the values from next_level to the queue
            for(int i=0; i<next_level.size(); i++) {
                queue.offer(next_level.get(i));
            }
        }
        return root;
    }
}