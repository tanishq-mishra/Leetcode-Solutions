class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        //List<Integer> empty = new ArrayList<>();
        ans.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0; i< nums.length; i++) {
            start = 0;
            if(i > 0 && nums[i] == nums[i-1]) {
                 start = end+1;
            }
            end = ans.size()-1;
            int n = ans.size();
            for(int j =start; j<n; j++) {
                List<Integer> newSubset = new ArrayList<>(ans.get(j));
                newSubset.add(nums[i]);
                ans.add(newSubset);
            }
        }
        
        return ans;
    }
    
    
    // public List<List<Integer>> subsetsWithDup(int[] arr) {
    //     Arrays.sort(arr);
    //     List<List<Integer>> outer = new ArrayList<>();
    //     outer.add(new ArrayList<>());
    //     int start = 0;
    //     int end = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         start = 0;
    //         // if current and previous element is same, s = e + 1
    //         if (i > 0 && arr[i] == arr[i-1]) {
    //             start = end + 1;
    //         }
    //         end = outer.size() - 1;
    //         int n = outer.size();
    //         for (int j = start; j < n; j++) {
    //             List<Integer> internal = new ArrayList<>(outer.get(j));
    //             internal.add(arr[i]);
    //             outer.add(internal);
    //         }
    //     }
    //     return outer;
    // }
    
    
}