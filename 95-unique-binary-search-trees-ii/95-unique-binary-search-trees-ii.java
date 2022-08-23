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
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> helper(int start, int end) {
        if(start > end) {
            List<TreeNode> trees = new ArrayList<>();
            trees.add(null);
            return trees;
        }
        List<TreeNode> trees = new ArrayList<>();
        
        for(int i = start; i<=end; i++) {
            List<TreeNode> leftSubTrees = helper(start, i-1);
            List<TreeNode> rightSubTrees = helper(i+1, end);
            
            for(TreeNode leftSubTree : leftSubTrees) {
                for(TreeNode rightSubTree : rightSubTrees) {
                    TreeNode current = new TreeNode(i, leftSubTree, rightSubTree);
                    trees.add(current);
                    
                }
            }
        }
        
        return trees;
        
    }
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
}