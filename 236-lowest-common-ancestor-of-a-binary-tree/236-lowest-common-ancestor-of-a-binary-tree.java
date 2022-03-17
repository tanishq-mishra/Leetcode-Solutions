/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean foundP = false;
    boolean foundQ = false;
    TreeNode found = null; 
    List<TreeNode> preOrder = new ArrayList<>();
    List<TreeNode> postOrder = new ArrayList<>();
    public void helper(TreeNode root, TreeNode p, TreeNode q ) {
        
        if(root == null) {
            return;
        }
        preOrder.add(root);
        helper(root.left, p, q);
        helper(root.right, p, q);
        postOrder.add(root);
        
//         if(root.val == p.val) {
//             foundP = true;
//         }
//         if(root.val == q.val) {
//             foundQ = true;
//         }
//         if(foundP && foundQ) {
//             if(found == null) {
//                 found = root;
//             } 
//         } 
            
            
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        boolean foundP = false;
        boolean foundQ = false;
        List<TreeNode> postOrderCandidates = new ArrayList<>();
        for(int i = 0; i< postOrder.size(); i++) {
            if(q.val == postOrder.get(i).val) {
                foundQ = true;
            }
            
            if(p.val == postOrder.get(i).val) {
                foundP = true;
            }
            
            if(foundQ && foundP) {
                postOrderCandidates.add(postOrder.get(i));
            }
        }
        
        int preOrderBound = Math.min(preOrder.indexOf(p),preOrder.indexOf(q));
        
        for(int i = preOrderBound ; i>= 0; i--) {
            if(postOrderCandidates.contains(preOrder.get(i))) {
                found = preOrder.get(i);
                break;
            }
        }
        
        return found;
    }
}