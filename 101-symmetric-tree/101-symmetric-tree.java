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
    
    public List<Integer> left;
    public List<Integer> right;
    public void traverseLeftSub(TreeNode root) {
        if(root == null) {
            left.add(null);
            return;
        }
            
        left.add(root.val);
        traverseLeftSub(root.left);
        traverseLeftSub(root.right);
    }
    public void traverseRightSub(TreeNode root) {
        if(root == null) {
            right.add(null);
            return;
        }
            
        right.add(root.val);
        traverseRightSub(root.right);
        traverseRightSub(root.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        left = new ArrayList<>();
        right = new ArrayList<>();
        
        traverseLeftSub(root.left);
        traverseRightSub(root.right);
        
        if(left.size() != right.size()) {
            return false;
        }
        
        
        for(int i = 0; i<left.size(); i++) {
            if(left.get(i) != right.get(i)) {
                return false;
            }
        }
        
        return true;
    }
}