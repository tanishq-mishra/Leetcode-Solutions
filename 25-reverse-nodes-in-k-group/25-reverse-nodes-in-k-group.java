/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = current.next;
        
        while(current != null && current.next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        
        current.next = prev;
        ListNode dummy = current;
        // while(dummy != null) {
        //     System.out.print(dummy.val + ", ");
        //     dummy  = dummy.next;
        // }
        //System.out.println();
        return current;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ArrayList<ListNode> groups = new ArrayList<>();
        
        
        
        
        
        
        ListNode prev = null;
        ListNode current = head;
        int length = 0;
        
        while(current != null) {
            length++;
            current = current.next;
        
        }
        int skipLast = 0;
        if(length%k != 0) {
            skipLast = 1;
        }
        
        current = head;
        
        
        int idx = 0;
        while(current!= null) {
            if(idx%k == 0) {
                if(prev != null) {
                    prev.next = null;
                    
                }
                
                groups.add(current);
            }
            
            prev = current;
            current = current.next;
            idx++;
        }
        
        for(int i = 0; i< groups.size()-skipLast; i++) {
            groups.set(i, reverse(groups.get(i)));
        }
        //System.out.println(groups.get(0).val);
         ListNode dummy = null;
        for(int i = 0; i< groups.size()-1; i++) {
            dummy = groups.get(i);
            while(dummy.next != null) {
                //System.out.print(dummy.val + ", ");
                dummy  = dummy.next;
            }
            dummy.next = groups.get(i+1);
        }
        
        if(dummy != null)
            dummy.next = groups.get(groups.size()-1);
        
        //System.out.println(groups.size());
        
        return groups.get(0);
        
    }
}