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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        
        
        do{
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }while(current.next !=null);
        current.next = prev;
        return current;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1; 
        int j = 1;
        
        
        if(head == null || head.next == null ||left == right) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;
        
        
        while(i<left) {
            prev = current;
            current = current.next;
            
            i++;
            j++;
        }
        
        ListNode start = current;
        ListNode startPrev = prev;
        
        while(j<right) {
            j++;
            current = current.next;
            
        }
        ListNode end = current;
        ListNode secondPart = current.next;
        end.next = null;
        ListNode reversed = reverseList(start);
        if(startPrev != null)
            startPrev.next = reversed;
        else {
            startPrev = reversed;
            head = reversed;
        }
        while(startPrev.next != null) {
            startPrev = startPrev.next;
        }
        
        
        
        startPrev.next = secondPart;
        
        return head;
        
        
        
        
        
    }
}