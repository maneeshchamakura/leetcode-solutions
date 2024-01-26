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
    private static class Node {
        int height;
        Node parent;
        Node left;
        Node right;
        Node(int height, Node parent) {
            this.height = height;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }
        public String toString() {
            return String.format("Height: %d left_height: %d right_height: %d parent: %d\n", 
                                 this.height, 
                                 get_height(this.left),
                                 get_height(this.right),
                                 get_height(this.parent)
                                );
        }
        public int get_height(Node node) {
            return node == null ? -1: node.height;
        }
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Node> valToNode = new HashMap<>();
        create_height_tree(root, valToNode);
        List<Integer> result = new ArrayList<>();
        for(int node_val: queries) {            
            result.add(find_updated_height(node_val, valToNode));
        }
        return result.stream().mapToInt(a -> (int)a).toArray();
    }
    
    public int find_updated_height(int node_val, Map<Integer, Node> valToNode) {
        // get the height node for the node_val
        Node current_height_node = valToNode.get(node_val);
        int old_height = current_height_node.height;
        // update this height to -1
        current_height_node.height = -1;
        int new_height = propagate_up(current_height_node.parent, valToNode);
        // update the height to old_height
        current_height_node.height = old_height;
        propagate_up(current_height_node.parent, valToNode);
        return new_height;
    }
    
    public int propagate_up(Node current_node, Map<Integer, Node> valToNode) {
        int left_height_val = current_node.left == null ? -1 : current_node.left.height;
        int right_height_val = current_node.right == null ? -1 : current_node.right.height;
        int new_height = 1 + Math.max(left_height_val, right_height_val);
        current_node.height = new_height;
        if (current_node.parent == null) return new_height;
        return propagate_up(current_node.parent, valToNode);
    }
    
    public Node create_height_tree(TreeNode root, Map<Integer, Node> valToNode) {
        if (root == null) return new Node(-1, null);
        Node left_node = create_height_tree(root.left, valToNode);
        Node right_node = create_height_tree(root.right, valToNode);
        Node current_node = new Node(Math.max(left_node.height, right_node.height) + 1, null);
        int node_val = root.val;
        if (left_node != null) {
            left_node.parent = current_node;
            current_node.left = left_node;
        }
        if (right_node != null) {
            right_node.parent = current_node;
            current_node.right = right_node;
        }
        valToNode.put(node_val, current_node);
        return current_node;
    }
}