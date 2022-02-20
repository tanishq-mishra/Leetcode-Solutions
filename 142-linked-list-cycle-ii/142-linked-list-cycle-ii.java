/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == null || fast == null) {
                return 0;
            }
            if(slow == fast) {
                ListNode temp = slow;
                int count = 0;
                do{
                    temp = temp.next;
                    count++;
                }
                while(temp != slow);
                return count;
            }
        }
        
        return 0;
    }
    public ListNode detectCycle(ListNode head) {
        int cycleLength = getLength(head);
        if(cycleLength == 0) {
            return null;
        }
        ListNode s = head;
        ListNode f = head;
        
        while(cycleLength > 0) {
            s = s.next;
            cycleLength--;
        }
        while(s != f) {
            s = s.next;
            f = f.next;
        }
        
        return s;
        
        
    }
    
    
    // Using HashMaps
    
//     public ListNode detectCycle(ListNode head) {
//         HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        
//         while(head != null) {
//             if(map.containsKey(head)) {
//                 return head;
//             }
//             map.put(head, 1);
//             head = head.next;
//         }
        
//         return null;
        
        
//     }
}