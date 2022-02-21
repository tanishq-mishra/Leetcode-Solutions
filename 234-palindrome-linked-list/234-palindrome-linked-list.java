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
    
    // Using extra List:

//     public boolean isPalindrome(ListNode head) {
//         // Create a new List and keep inserting at the beginning.
//         ListNode l1 = head;
        
//         ListNode l2 = new ListNode(head.val);
        
//         //ListNode head2 = l2;
        
//         while(l1 != null) {
//             ListNode temp = new ListNode(l1.val);
//             temp.next = l2;
//             l2 = temp;
//             l1 = l1.next;
//         }
        
//         l1 = head;
        
//         while(l1 != null) {
//             if(l1.val != l2.val) {
//                 return false;
//             }
//             l1 = l1.next;
//             l2 = l2.next;
//         }
        
        
//         return true;
//     }
    
    // Using half Reverse:
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        do{
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != null  && fast.next != null);
        
        ListNode middle = slow;
        prev.next = null;
        
        ListNode reversed = reverseList(middle);
        
        while(head!= null && reversed!=null) {
            if(head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
            
            return true;
    }
    
    
}