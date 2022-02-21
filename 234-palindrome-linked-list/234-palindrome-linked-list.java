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
    public boolean isPalindrome(ListNode head) {
        // Create a new List and keep inserting at the beginning.
        ListNode l1 = head;
        
        ListNode l2 = new ListNode(head.val);
        
        //ListNode head2 = l2;
        
        while(l1 != null) {
            ListNode temp = new ListNode(l1.val);
            temp.next = l2;
            l2 = temp;
            l1 = l1.next;
        }
        
        l1 = head;
        
        while(l1 != null) {
            if(l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        
        return true;
        
        
    }
}