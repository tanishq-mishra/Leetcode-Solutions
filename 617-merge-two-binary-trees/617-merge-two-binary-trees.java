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
    
    public TreeNode helper(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        
        
        int sum = 0;
        if(root1 != null) {
            sum += root1.val;
        }
        
        if(root2 != null) {
            sum += root2.val;
        }
        
        
        TreeNode newNode = new TreeNode(sum);
        
        newNode.left = helper(root1 != null ? root1.left : null , root2 != null ? root2.left: null);
        newNode.right = helper(root1 != null ? root1.right : null , root2 != null ? root2.right: null);
            
        return newNode;
        
        
        
        
    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        
        
        TreeNode merged;
        
        merged = helper(root1, root2);
        return merged;
    }
}