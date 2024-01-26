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
    Map<String, Integer> map;
    Map<Integer, Integer> uid;
    int t =1;
    List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t=1;
        map = new HashMap<>();
        uid = new HashMap<>();
        result = new ArrayList<>();
        collect(root);
        return result;
    }
    
    public int collect(TreeNode root) {
        if (root == null) return 0;
        String serial = root.val + "," + collect(root.left) + "," + collect(root.right);
        int id = map.computeIfAbsent(serial, x -> t++);
        uid.put (id, uid.getOrDefault(id, 0) + 1);
        if (uid.get(id) == 2) {
            result.add(root);
        }
        return id;
    }
    
}