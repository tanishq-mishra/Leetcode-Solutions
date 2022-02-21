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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        
        int length = 0;
        
        ListNode counter = head;
        
        while(counter != null) {
            counter = counter.next;
            length++;
        }
        
        k = k %length;
        
        if(k == 0) {
            return head;
        }
        int skipNodes = length - k;
        
        
        ListNode current = head;
        ListNode prev = null;
        while(skipNodes > 0) {
            skipNodes--;
            prev = current;
            current = current.next;
        }
        
        
        prev.next = null;
        
        
        ListNode tail = current;
        
        while(tail.next != null) {
            tail = tail.next;
        }
        
        tail.next = head;
        
        return current;
        
    }
}