/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> s =  new Stack<>();
        Node tail = head;
        Node prev = null;
        while(tail != null) {
            if(tail.child != null) {
                if(tail.next != null ) {
                    s.push(tail.next);
                    tail.next.prev = null;
                }
                Node temp = tail.child;
                tail.next = temp;
                temp.prev = tail;
                tail.child = null;
            } 
            // else {
            //     if(!s.empty()){
            //         Node temp = s.pop();
            //         tail.next = temp;
            //         temp.prev = tail;
            //     }
            // }
            prev = tail;
            tail = tail.next;
        }
        
        while(!s.empty()) {
            Node temp = s.pop();
            
            prev.next =temp;
            temp.prev = prev;
            while(prev.next != null) {
                prev = prev.next;
            }
        }
        
        
        return head;
        
    }
}