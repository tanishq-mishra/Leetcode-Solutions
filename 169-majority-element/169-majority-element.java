
//HashMap
// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> st = new HashMap<>();
        
//         for(int i: nums) {
//             if(st.containsKey(i)) {
//                 st.put(i, st.get(i) +1);
//             } else {
//                 st.put(i, 1);
//             }
//         }
        
//         for(Map.Entry<Integer,Integer> entry : st.entrySet()) {
//             if(entry.getValue() > nums.length/2) {
//                 return entry.getKey();
//             }
//         }
        
//         return -1;
        
        
        
//     }
// }


// Boyer-Moore Voting Algorithm


class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}