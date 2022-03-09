// O(nLog(n)) => sorting
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if(nums.length == 0) {
//             return 0;
//         }
//         Arrays.sort(nums);
        
        
//         int longest = 0;
//         int current =1;
//         for(int i = 0; i< nums.length -1; i++) {
//             if(nums[i] == nums[i+1]-1) {
                
//                 current++;
//             } else if(nums[i] == nums[i+1]) {
                
//             }
//             else {
                
//                 longest = Math.max(longest, current);
//                 current = 1;
//             }
//         }
        
//         longest = Math.max(longest, current);
        
//         return longest;
//     }
// }

// O(n) => using set;
class Solution {
        public int longestConsecutive(int[] nums) {
        HashSet set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int count = i;
                while(set.contains(count)){
                    count++;
                }
                max = Math.max(count - i, max);
            }
        }
        return max;
    }
}