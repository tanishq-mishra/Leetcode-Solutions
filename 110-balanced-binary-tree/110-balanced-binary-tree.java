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
    public boolean balanced  = true;
    public int helper(TreeNode root) {
        if(!balanced) {
            return 0;
        }
        if(root == null) {
            return 0;
        }
        
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        int difference = leftHeight - rightHeight;
        
        if((difference < -1 || difference > 1)) {
            balanced = false;
            return 0;
        }
        
        
        
        return Math.max(leftHeight, rightHeight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        
        helper(root);
        
        return balanced;
        
    }
}