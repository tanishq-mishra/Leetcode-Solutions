/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Iterative

class Solution {
    
    private HashMap <Node, Node> visited = new HashMap <> ();
    public Node cloneGraphRecur(Node node) {
        if (node == null) {
            return node;
        }
        
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        Node cloneNode = new Node(node.val, new ArrayList());
        
        visited.put(node, cloneNode);
        
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraphRecur(neighbor));
        }
        
        return cloneNode;
    }
    
    public Node cloneGraphIterative(Node node) {
        if(node == null) {
            return node;
        }
        
        if(node.neighbors.size() == 0) {
            return new Node(node.val);
        }
        List<Node> queueOriginal = new ArrayList<>();
        List<Node> queueCopy = new ArrayList<>();
        HashSet<Node> visited = new HashSet<>();
        HashMap<Node, Node> pairs = new HashMap<>();
        queueOriginal.add(node);
        while(!queueOriginal.isEmpty()) {
            Node current = queueOriginal.get(0);
            queueOriginal.remove(0);
        
            if(!visited.contains(current)) {
                visited.add(current);
                for(Node neighbor : current.neighbors) {
                    queueOriginal.add(neighbor);
                    if(!pairs.containsKey(neighbor)) {
                        pairs.put(neighbor,new Node(neighbor.val));
                    }
                    
                }
            }
        }
        
        visited.clear();
        queueOriginal.add(node);
        queueCopy.add(pairs.get(node));
        Node copy = pairs.get(node);
        while(!queueOriginal.isEmpty()) {
            Node current = queueOriginal.get(0);
            queueOriginal.remove(0);
            
            Node currentCopy = queueCopy.get(0);
            queueCopy.remove(0);
        
            if(!visited.contains(current)) {
                visited.add(current);
                for(Node neighbor : current.neighbors) {
                    queueOriginal.add(neighbor);
                    queueCopy.add(pairs.get(neighbor));
                    currentCopy.neighbors.add(pairs.get(neighbor));
                }
            }
        }
        return copy;
    }
    
    public Node cloneGraph (Node node) {
        
        boolean iterative = false;
        
        if(iterative) {
            return cloneGraphIterative(node);
        } else {
            return cloneGraphRecur(node);
        }
        
    }
}
