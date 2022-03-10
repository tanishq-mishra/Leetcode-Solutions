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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        
        while(head != null && head.val == val) {
            head = head.next;
        }
        ListNode tail = head;
        ListNode prev = null;
        while(tail != null) {
            if(tail.val == val) {
                ListNode next = tail.next;
                if(prev != null) {
                    prev.next = tail.next;
                }
                tail.next = null;
                tail = next;
               
            } else {
                prev = tail;
                tail = tail.next;
            }
        }
        
        return head;
    }
}