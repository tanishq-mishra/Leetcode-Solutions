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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = head.next;
        ListNode next = newHead.next;
        ListNode current = newHead;
        ListNode prev = head;
        ListNode lastLink = null;
        
         while(prev!= null && current != null) {
             
             current.next = prev;
             prev.next = next;
             if(lastLink != null) {
                 lastLink.next = current;
             }
             
             lastLink = prev;
             prev = next;
             if(next != null) {
                current = next.next;
                 if(current != null) {
                     next = current.next;
                 }
                     
                
             }
             
             
             
             
         }
        return newHead;
        
        
    }
}