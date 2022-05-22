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
    
    public int counter = 0;
    public void helper(TreeNode root, int targetSum, int originalSum) {
        if(root == null) {
            return;
        }
        
        if(targetSum-root.val == 0) {
            counter++;
        }
            
            helper(root.left,targetSum-root.val,originalSum);
            helper(root.right, targetSum-root.val,originalSum);
            

    }
    
    
    public void traverse(TreeNode root, int targetSum) {
        if(root == null) 
            return;
        
        helper(root, targetSum, targetSum);
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        
        traverse(root, targetSum);
        
        
        return counter;
    }
} 