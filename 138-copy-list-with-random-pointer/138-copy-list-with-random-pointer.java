/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public int findRandom(Node node,  Node random) {
        if(random == null) {
            return -1;
        }
        int i = 0;
        while(node != random) {
            node = node.next;
            i++;
        }
        
        return i;
    }
    
    public Node findNode(Node head, int index) {
        while(index > 0) {
            head = head.next;
            index--;
        }
        
        return head;
    } 
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
       
        Node cloneHead = new Node(head.val);
        Node tail = head;
        Node cloneTail = cloneHead;
        tail = tail.next;
        int length = 1;
        
        while(tail != null) {
            length++;
            cloneTail.next = new Node(tail.val);
            tail = tail.next;
            cloneTail = cloneTail.next;
        }
        tail = head;
        cloneTail = cloneHead;
        int i = 0;
        while(i<length) {
            int randomIndex = findRandom(head, tail.random);
            
            if(randomIndex == -1) {
                cloneTail.random = null;
            } else {
                Node randomNode = findNode(cloneHead, randomIndex);
                cloneTail.random = randomNode;
            }
            
            tail = tail.next;
            cloneTail = cloneTail.next;
            i++;
        }
       
        
        return cloneHead;
        
    }
}