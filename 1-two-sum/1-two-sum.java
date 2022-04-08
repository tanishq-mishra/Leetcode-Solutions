class Solution {
public:
    
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> visited;
        
        for(int i = 0 ; i< nums.size(); i++) {
            int first = target - nums[i];
            if(visited.find(first)  != visited.end()) {
                return {visited[first], i};
            } else {
                visited[nums[i]] = i;
            }
        }
        
        return {-1, -1};
    }
};