/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode head = node;
        
        while(head.next.next != null) {
            head.val = head.next.val;
            head = head.next;
            // if(head.next.next == null) {
            //     head.val = head.next.val;
            //     head.next = null;
            // }
            
        }
        head.val = head.next.val;
        head.next = null;
        
        
    }
}