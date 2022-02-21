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
        ListNode prev = head;
        do{
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
            
        } while(fast != null && fast.next != null);
        
        // Breaking the List in half;
        prev.next = null;
        
        return slow;
    }
    
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
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        
        
        ListNode start = list1;
        list1 = list1.next;
        ListNode head = start;
        boolean switchNode = false;
        while(list1 != null && list2 != null) {
            if(switchNode) {
                start.next = list1;
                start = start.next;
                list1 = list1.next;
            } else {
                start.next = list2;
                start = start.next;
                list2 = list2.next;
            }
            switchNode = !switchNode;
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
    
    public void printList(ListNode head){
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public void reorderList(ListNode head) {
        if( head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        // First get the middle of the Linked List;
        ListNode middle = middleNode(head);
        
        // Reverse the second half;
        middle = reverseList(middle);
        // Merge the 2 Halves;
        head = mergeTwoLists(head, middle);
    }
}