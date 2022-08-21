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
            path += String.valueOf(root.val);
            res.add(path);
            return;
        }
        path += Integer.toString(root.val);
        path +="->";
        helper(root.left, path);
        helper(root.right, path);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        
        helper(root, "");
        
        return res;
        
    }
}