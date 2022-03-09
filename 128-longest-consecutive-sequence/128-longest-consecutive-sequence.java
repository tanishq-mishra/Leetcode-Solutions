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

public class Solution {
public int longestConsecutive(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    
    Set<Integer> set = new HashSet<Integer>();
    
    for(int num: nums) set.add(num);
    int max = 1;
    for(int num: nums) {
        if(set.remove(num)) {//num hasn't been visited
            int val = num;
            int sum = 1;
            while(set.remove(val-1)) val--;
            sum += num - val;
            
            val = num;
            while(set.remove(val+1)) val++;
            sum += val - num;
            
            max = Math.max(max, sum);
        }
    }
    return max;
}
}