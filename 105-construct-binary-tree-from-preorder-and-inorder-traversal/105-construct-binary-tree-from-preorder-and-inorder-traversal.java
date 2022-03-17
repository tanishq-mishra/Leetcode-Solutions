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
    int preStart = 0;
    HashMap<Integer, Integer> inorderMap = new HashMap();
    public TreeNode helper( int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart++]);
        
        // int inIndex = inorderMap.get(root.val);
        int inIndex = 0;
        for(int i = inStart; i<=inEnd;i++) {
            if(root.val == inorder[i]) {
                inIndex = i;
            }
        }
        
        root.left = helper(inStart, inIndex-1, preorder, inorder);
        root.right = helper(inIndex + 1, inEnd, preorder, inorder);
        
        
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // for(int i = 0; i< inorder.length; i++) {
        //     inorderMap.put(inorder[i], i);
        // }
        return helper(0, inorder.length-1, preorder, inorder);
    }
}