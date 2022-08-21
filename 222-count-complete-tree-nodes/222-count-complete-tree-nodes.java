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
    public int missing = 0;
    public int levels = 0;
    public boolean completed = false;
    public int getLevels(TreeNode root) {
         if(root == null) {
             return 0;
         }
         
         return 1 + getLevels(root.left);
    }
    
    public void seekMissing(TreeNode root, int currentLevel) {
        if(completed) {
            return;
        }
        
        if(currentLevel > levels-1) {
            return;
        }
        if(currentLevel == levels-1) {
            if(root.left == null && root.right == null) {
                missing+=2;
                return;
            }
            if(root.right == null) {
                missing++;
                completed= true;
                return;
            }
            
            completed = true;
            return;
        }
        
        seekMissing(root.right, currentLevel+1);
        seekMissing(root.left, currentLevel+1);
    }
    
    
    public int countNodes(TreeNode root) {
        levels = getLevels(root);
        if(levels == 1 || levels == 0) {
            return levels;
        }
        
        int maxPossibleNodes = (int)Math.pow(2, levels) -1;
        
        //System.out.println(maxPossibleNodes);
        seekMissing(root, 1);
        
        return maxPossibleNodes-missing;
        
        
    }
}