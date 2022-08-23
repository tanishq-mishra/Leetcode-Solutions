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
    public List<Integer> levels = new ArrayList<>();
    
    public void helper(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        
        if(levels.size() > level) {
            levels.set(level, levels.get(level)+node.val);
        } else {
            levels.add(node.val);
        }
        helper(node.left, level+1);
        helper(node.right, level+1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        helper(root, 0);
        
        return levels.get(levels.size()-1);
    }
}