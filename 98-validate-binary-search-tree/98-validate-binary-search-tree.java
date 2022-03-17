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
    List<Integer> inorderList = new ArrayList<>();
    public boolean helper(TreeNode root) {
        if(inorderList.size()>1) {
            if(inorderList.get(inorderList.size()-1) <=inorderList.get(inorderList.size()-2))
                return false;
        }
        if(root == null) {
            return true;
        }
        
        boolean left = helper(root.left);
        inorderList.add(root.val);
        if(left == false) {
            return false;
        }
        boolean right =helper(root.right);
        
        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root);
        
        
    }
}