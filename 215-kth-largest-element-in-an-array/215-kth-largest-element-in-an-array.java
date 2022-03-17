class Solution {
    int pos;
    int element = Integer.MIN_VALUE;
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public int findpivot(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start+1;
        int j = end;
        if(i == j) {
            if(pivot > nums[i]) {
                swap(nums, i, start);
            }
            return j;
        }
        
        while(i < j) {
            while(i <=end && nums[i] <= pivot) {
                i++;
            }
            while(j >= start + 1 && nums[j] > pivot ) {
                j--;
            }
            if(i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, j, start);
        return j;
        
        
    }
    public void quickSelect(int[] nums, int start, int end) {
        if(start < end && element == Integer.MIN_VALUE) {
            int p = findpivot(nums, start, end);
            if(p == pos) {
                element = nums[p];
                return;
            }
            if(p > pos) {
                quickSelect(nums, start, p-1);
            } else {
                quickSelect(nums, p+1, end);
            }
            
            
        }
        
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) {
            return nums[0];
        }
        this.pos = nums.length - k;
        
        quickSelect(nums, 0, nums.length-1);
        if(element == Integer.MIN_VALUE)
            element = nums[pos];
        
        return element;
        
    }
}

