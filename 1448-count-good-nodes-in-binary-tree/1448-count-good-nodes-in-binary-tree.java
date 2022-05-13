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
    public void helper(TreeNode root, int largest) {
        if(root == null) {
            return;
        }
        helper(root.left, Math.max(largest, root.val));
        if(largest <= root.val) {
            res++;
        }
        helper(root.right, Math.max(largest, root.val));
    }
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        
        return res;
    }
}