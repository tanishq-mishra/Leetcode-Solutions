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
    public int maxDepth = 0;
    public int sum = 0;
    public void getMaxDepth(TreeNode node, int level) {
        if(node == null) {
            
            return;
        }
        if(node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, level);
            return;
        }
        getMaxDepth(node.left, level+1);
        getMaxDepth(node.right, level+1);
    }
    
    public void helper(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(level == maxDepth) {
            
            sum+=node.val;
            return;
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
        getMaxDepth(root, 0);
        helper(root, 0);
        
        return sum;
    }
}