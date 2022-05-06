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
    public int maxSum = Integer.MIN_VALUE;
    public int helper(TreeNode root) {
         if(root == null) {
            return 0;
        }
        
        int sumLeft = helper(root.left);
        int sumRight = helper(root.right);
        sumLeft = Math.max(sumLeft, 0);
        sumRight = Math.max(sumRight, 0);
        
        // taking both
        
        int splitting = sumLeft + root.val + sumRight;
        maxSum = Math.max(maxSum, splitting);
        
            
        
        
        return Math.max(root.val ,root.val + Math.max(sumRight, sumLeft));
    }
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        
        return maxSum;
        
       
        
        
        
    }
}