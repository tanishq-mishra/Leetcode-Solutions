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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null) {
            return head;
        }
        if(n == 0) {
            return head;
        }
        if(head.next == null && n == 1) {
            return null;
        }
        
        int length = 0;
        ListNode start = head;
        
        while(start != null) {
            start = start.next;
            length++;
        }
        
        int skip = length-n;
        if(skip == 0) {
            return head.next;
        }
        
        ListNode prev = null;
        ListNode current = head;
        
        while(skip>0) {
            prev = current;
            current = current.next;
            
            skip--;
        }
        
        prev.next = current.next;
        current.next = null;
        
        return head;
        
    }
}