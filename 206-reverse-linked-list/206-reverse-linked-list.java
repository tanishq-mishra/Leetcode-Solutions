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
}

// 1 <- 2 <- 3 <- 4 -> 5
// prev = null;
// current = 1;
// next = 2;


// reversing

// current.next = prev;
// prev = current; => prev = 4;
// current = next; => current = 5;
// next = current.next; => next = null;



