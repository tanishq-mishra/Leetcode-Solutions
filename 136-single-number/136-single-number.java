class Solution {
//     public int singleNumber(int[] nums) {
//         HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        
//         for(int i = 0; i<nums.length; i++) {
//             if(count.containsKey(nums[i])) {
//                 count.put(nums[i], count.get(nums[i]) + 1 );
//             } else {
//                 count.put(nums[i], 1);
//             }
//         }
        
//         for(Map.Entry<Integer,Integer> entry : count.entrySet()) {
//             if(entry.getValue() == 1) {
//                 return entry.getKey();
//             }
//         }
        
//         return -1;
//     }
    
    public int singleNumber(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        
        for(int i = 0; i< nums.length-1; i+=2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length -1];
    }
}