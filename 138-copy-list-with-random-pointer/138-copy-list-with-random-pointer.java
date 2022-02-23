class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        HashMap<Node,Node> hm=new HashMap<>();
        Node temp=head;
        Node newHead= null;
        while(temp!=null)
        {
            Node copyNode = new Node(temp.val);
            hm.put(temp,copyNode);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null)
        {
            Node copyNode=hm.get(temp);
            copyNode.random=hm.get(temp.random);
            copyNode.next=hm.get(temp.next);
            if(newHead==null)
                newHead=copyNode;
            temp=temp.next;
        }
        return newHead;
    }
}