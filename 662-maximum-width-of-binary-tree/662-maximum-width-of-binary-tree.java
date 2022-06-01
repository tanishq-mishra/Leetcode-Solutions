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
    
    public HashMap<Integer, Integer> leftMostAtLevel;
    public int maxWidth = 0;
    
    public void helper(TreeNode current, int level, int position) {
        if(current == null) {
            return;
        }
        
        if(!leftMostAtLevel.containsKey(level)) {
            leftMostAtLevel.put(level,position);
        }
        
        maxWidth = Math.max(position - leftMostAtLevel.get(level) +1, maxWidth);
        
        helper(current.left, level+1, position*2);
        helper(current.right, level+1, (position*2)+1);
        
        
        
        
    }
    
    
    public int widthOfBinaryTree(TreeNode root) {
        leftMostAtLevel = new HashMap<>();
        helper(root, 0, 1);
        
        return maxWidth;
    }
}