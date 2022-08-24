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
    int deepestNode = 0;
    public void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            deepestNode = Math.max(deepestNode, level);
            return;
        }
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
    
    TreeNode res = null;
    TreeNode lowest = null;
    
    public int seek(TreeNode root, int level) {
        if(root == null) {
            return -1;
        }
        if(root.left == null && root.right == null) {
            if(level == deepestNode) {
                lowest = root;
            }
            return level;
        }
        
        int leftDepth = seek(root.left, level+1);
        int rightDepth = seek(root.right, level+1);
        if(leftDepth == deepestNode && rightDepth == deepestNode) {
            res = root;
            
        }
        
        return Math.max(leftDepth, rightDepth);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        dfs(root, 0);
        
        
        seek(root, 0);
        return res != null ? res : lowest;
        
    }
}