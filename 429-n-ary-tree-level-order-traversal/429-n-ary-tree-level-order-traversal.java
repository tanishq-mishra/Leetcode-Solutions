/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // bfs solution
    
    
/*    public List<List<Integer>> levelOrder(Node root) {
        
        ArrayList<Node> queue = new ArrayList<Node>();
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        queue.add(root);
        
        while(!queue.isEmpty()) {
            ArrayList<Node> nextLevel = new ArrayList<>();
            List<Integer> currentLevelResult = new ArrayList<>();
            while(!queue.isEmpty()) {
                Node current = queue.get(0);
                queue.remove(0);
                currentLevelResult.add(current.val);
                if(current.children != null) {
                    nextLevel.addAll(current.children);
                }
                
                
            }
            queue.addAll(nextLevel);
            res.add(currentLevelResult);
        }

        return res;
    }
*/
    
    // dfs solution
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,root,0);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans,Node node,int depth){
        if(node==null){
            return;
        }
        if(depth>ans.size()-1){
            List<Integer> trav = new ArrayList<>();
            trav.add(node.val);
            ans.add(trav);
        }
        else{
            ans.get(depth).add(node.val);
        }
        for(int i=0;i<node.children.size();i++){
            helper(ans,node.children.get(i),depth+1);
        }
    }
    
}