/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode start = headA;
        HashSet<ListNode> visited = new HashSet<>();
        while(start != null) {
            visited.add(start);
            start = start.next;
        }
        start = headB;
        while(start != null) {
            if(visited.contains(start)) {
                return start;
            }
            start = start.next;
        }
        
        
        return null;
    }
}