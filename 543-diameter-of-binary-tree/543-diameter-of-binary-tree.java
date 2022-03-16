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
    int res = 0;
    public int helper(TreeNode root) {
       if(root == null) {
           return  -1;
       }
        
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left +right +2);
        int height = Math.max(left, right) +1;
        
        return height;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        
        return res;
    }
}