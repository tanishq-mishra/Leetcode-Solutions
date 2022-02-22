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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digitSum = l1.val + l2.val;
        int carry = 0;
        if(digitSum >= 10) {
            carry = 1;
            digitSum = digitSum % 10;
        }
        
        ListNode sum = new ListNode(digitSum);
        ListNode tail = sum;
        l1 = l1.next;
        l2 = l2.next;
        digitSum = 0;
        while(l1 != null & l2 != null) {
            digitSum = l1.val +l2.val + carry;
            if(digitSum >= 10) {
                carry = 1;
                digitSum = digitSum % 10;
            } else {
                carry = 0;
            }
            
            tail.next = new ListNode(digitSum);
            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;
        }
        
        while(l1 != null) {
            digitSum = l1.val + carry;
            if(digitSum >= 10) {
                carry = 1;
                digitSum = digitSum % 10;
            } else {
                carry = 0;
            }
            tail.next = new ListNode(digitSum);
            tail = tail.next;
            l1 = l1.next;
            
        }
        
        while(l2 != null) {
            digitSum = l2.val + carry;
            if(digitSum >= 10) {
                carry = 1;
                digitSum = digitSum % 10;
            } else {
                carry = 0;
            }
            
            tail.next = new ListNode(digitSum);
            tail = tail.next;
            l2 = l2.next;
            
        }
        
        
        if(carry == 1) {
            tail.next = new ListNode(1);
        }
        
        
        
        
        
        return sum;
         
    }
}