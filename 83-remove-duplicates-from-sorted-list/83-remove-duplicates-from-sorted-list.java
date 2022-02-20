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
    
    public void helper(ListNode current, ListNode prev) {
        if(current == null) {
            return;
        }
        if(prev != null && prev.val == current.val) {
            prev.next = current.next;
            current = prev;
        } 
        
        helper(current.next,current);
    }
    public ListNode deleteDuplicates(ListNode head) {
        helper(head, null);
        return head;
    }
}