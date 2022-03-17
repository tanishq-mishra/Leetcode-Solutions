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
    public List<Integer> helper(TreeNode root) {
        if(root == null) {
            List<Integer> inorderList = new ArrayList<>();
            
            return inorderList;
        }
        List<Integer> inorderList = new ArrayList<>();
        inorderList.addAll(helper(root.left));
        inorderList.add(root.val);
        inorderList.addAll(helper(root.right));
        
        
        return inorderList;
         
        
        
    }
    public boolean isValidBST(TreeNode root) {
        
        List<Integer> inorderList = helper(root);
        
        for(int i =0; i<inorderList.size()-1; i++) {
            if(inorderList.get(i) >= inorderList.get(i+1)) {
                return false;
            }
        }
        return true;
        
        
    }
}