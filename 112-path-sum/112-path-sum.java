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
    
    public boolean helper(TreeNode root, int targetSum) {
        if(root.left == null && root.right == null) {
            if(targetSum - root.val == 0) {
                return true;
            }
            return false;
        }
        if(root.left != null) {
            Boolean left = helper(root.left, targetSum-root.val);
            if(left) {
                return left;
            }
        }
        if(root.right != null) {
            if(helper(root.right, targetSum-root.val)) {
                return true;
            }
        }
        
        
        return false;
        
        
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        return helper(root, targetSum);
    }
}