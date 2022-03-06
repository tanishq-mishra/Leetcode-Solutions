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

// Converting problem to merge Two Lists;
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         if(list1 == null) {
//             return list2;
//         }
//         if(list2 == null) {
//             return list1;
//         }
//         ListNode start;
//         if(list1.val < list2.val) {
//             start = list1;
//             list1 = list1.next;
//         } else {
//             start = list2;
//             list2 = list2.next;
//         }
        
//         ListNode head = start;
//         while(list1 != null && list2 != null) {
//             if(list1.val < list2.val) {
//                 start.next = list1;
//                 start = start.next;
//                 list1 = list1.next;
//             } else {
//                 start.next = list2;
//                 start = start.next;
//                 list2 = list2.next;
//             }
//         }
        
//         while(list1 !=null) {
//             start.next = list1;
//             start = start.next;
//             list1 = list1.next;
//         }
//         while(list2!=null) {
//             start.next = list2;
//             start = start.next;
//             list2 = list2.next;
//         }
        
//         return head;  
//     }
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length == 0 ) {
//             return null;
//         }
        
//         if(lists.length == 1) {
//             return lists[0];
//         }
        
        
//         int totalLists = lists.length;
//         ListNode merged = mergeTwoLists(lists[0],lists[1]);
        
//         int i = 2;
//         for(i = 2 ; i< totalLists; i++) {
//             merged = mergeTwoLists(lists[i], merged);
            
//         }

        
//         return merged;
        
//     }
// }


// using priority Queue;
class Solution {  
    
    class DataComparator implements Comparator <ListNode> {
        public int compare (ListNode l1, ListNode l2 ){  //CREATED A COMPARATOR  TO CHECK BIG OR SMALL VALUES
            if(l1.val>l2.val)
                return 1;
            else if(l2.val>l1.val){
                return -1;
            }else
                return 0;
            
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
       
        PriorityQueue<ListNode> st=new PriorityQueue<>(new DataComparator());
       
            for( ListNode head: lists ){       //ADDING ALL THE NODE INTO PRIORITY-QUEUE
                while(head!=null){
                    st.add(head);
                    head=head.next;
                }
            }
                ListNode res=null,ans=null;
        
        while(!st.isEmpty()){
            if(res==null){      
                res=st.poll();      //CREATING HEAD i.e(ans)
                 ans=res;
            } else {
                res.next=st.poll();    // ALL THE NODES TO HEAD 
                res=res.next;
                
            }
        }
        
        if(res!=null)
            res.next=null;  // MAKING SURE LAST NODE POINTS TO NULL
        
        return ans;  //RETURN HEAD NODE.
    }
}