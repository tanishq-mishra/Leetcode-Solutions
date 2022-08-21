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
    List<TreeNode> preOrder;
    
    public void helper(TreeNode root) {
        if(root == null)
            return;
        
        preOrder.add(root);
        helper(root.left);
        helper(root.right);
    }
    
    public void flatten(TreeNode root) {
        
        if( root == null || root.left == null && root.right == null) {
            return;
        }
        preOrder = new ArrayList<>();
        helper(root);
        preOrder.add(null);
        for(int i = 0; i< preOrder.size()-1; i++) {
            preOrder.get(i).right = preOrder.get(i+1);
            preOrder.get(i).left = null;
        }
        
    }
}