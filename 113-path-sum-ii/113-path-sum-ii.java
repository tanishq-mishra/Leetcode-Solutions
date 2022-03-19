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
    public List<List<Integer>> sumList = new ArrayList<>();
    
    public void helper(TreeNode root, int targetSum, List<Integer> listSoFar) {
        if(root == null) {
            return;
        }
        if(targetSum == root.val && root.left == null && root.right == null) {
            listSoFar.add(root.val);
            sumList.add(new ArrayList<>(listSoFar));
            listSoFar.remove(listSoFar.size()-1);
            return;
        }
        
        
            targetSum -= root.val;
            listSoFar.add(root.val);
            if(root.left != null) {
                helper(root.left, targetSum, listSoFar);
            }
            if(root.right!= null) {
                helper(root.right, targetSum, listSoFar);
            }
            
            listSoFar.remove(listSoFar.size()-1);
        
        
        
        
        
        
        
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());
        
        
        return sumList;
        
    }
}