/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     boolean foundP = false;
//     boolean foundQ = false;
//     TreeNode found = null; 
//     List<TreeNode> preOrder = new ArrayList<>();
//     List<TreeNode> postOrder = new ArrayList<>();
//     public void helper(TreeNode root, TreeNode p, TreeNode q ) {
        
//         if(root == null) {
//             return;
//         }
//         preOrder.add(root);
//         helper(root.left, p, q);
//         helper(root.right, p, q);
//         postOrder.add(root);
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         helper(root, p, q);
//         boolean foundP = false;
//         boolean foundQ = false;
//         List<TreeNode> postOrderCandidates = new ArrayList<>();
//         for(int i = 0; i< postOrder.size(); i++) {
//             if(q.val == postOrder.get(i).val) {
//                 foundQ = true;
//             }
            
//             if(p.val == postOrder.get(i).val) {
//                 foundP = true;
//             }
            
//             if(foundQ && foundP) {
//                 postOrderCandidates.add(postOrder.get(i));
//             }
//         }
        
//         int preOrderBound = Math.min(preOrder.indexOf(p),preOrder.indexOf(q));
        
//         for(int i = preOrderBound ; i>= 0; i--) {
//             if(postOrderCandidates.contains(preOrder.get(i))) {
//                 found = preOrder.get(i);
//                 break;
//             }
//         }
        
//         return found;
//     }
// }



class Solution {

    private TreeNode ans;

    public Solution() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}