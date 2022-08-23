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
    
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        
        for(int[] d : descriptions) {
            TreeNode parent = nodes.getOrDefault(d[0], new TreeNode());
            parent.val = d[0];
            TreeNode child = nodes.getOrDefault(d[1], new TreeNode());
            child.val = d[1];
            if(d[2] == 1) {
                parent.left = child;
                
            } else {
               parent.right = child;
                
            }
            nodes.put(d[1], child);
            nodes.put(d[0], parent);
            
            
        }
        for(int[] d : descriptions) {
            nodes.remove(d[1]);
        }
        TreeNode root = nodes.get(nodes.keySet().toArray()[0]);
        
        
        
        return root;
    }
}