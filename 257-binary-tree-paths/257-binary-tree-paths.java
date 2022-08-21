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
    List<String> res;
    
    public void helper(TreeNode root, String path) {
        if(root == null) {
            return;
        }
        
        
        if(root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        
        helper(root.left, path + root.val+"->");
        helper(root.right, path + root.val+"->");
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        
        helper(root, "");
        
        return res;
        
    }
}