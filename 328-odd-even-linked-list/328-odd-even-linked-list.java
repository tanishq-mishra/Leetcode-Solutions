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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        boolean isOdd = true;
        ListNode tail = head.next.next;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        evenHead.next = null;
        oddHead.next = null;
        
        while(tail != null) {
            
            if(isOdd) {
                oddTail.next = tail;
                oddTail = oddTail.next;
            } else {
                evenTail.next = tail;
                evenTail = evenTail.next;
            }
            
            isOdd = !isOdd;
            tail = tail.next;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        
        return oddHead;
    }
}