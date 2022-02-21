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
    
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        do{
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
            
            
                
        } while(fast != null && fast.next != null);
        
        prev.next = null;
        return slow;
        
    }
    
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode start;
        if(list1.val < list2.val) {
            start = list1;
            list1 = list1.next;
        } else {
            start = list2;
            list2 = list2.next;
        }
        
        ListNode head = start;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                start.next = list1;
                start = start.next;
                list1 = list1.next;
            } else {
                start.next = list2;
                start = start.next;
                list2 = list2.next;
            }
        }
        
        while(list1 !=null) {
            start.next = list1;
            start = start.next;
            list1 = list1.next;
        }
        while(list2!=null) {
            start.next = list2;
            start = start.next;
            list2 = list2.next;
        }
        
        return head;  
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode middle = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        
        return mergeTwoLists(left, right);
        
    }
}