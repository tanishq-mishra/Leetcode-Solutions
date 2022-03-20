class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Time: O(N + min(M * N, K) * logN)
        // Space: O(N) + O(1)
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        
        int m = nums1.length;
        int n = nums2.length;
        for(int i = 0; i < n && i < k; i++) { // i < k improves runtime
            pq.offer(new int[] {nums1[0], nums2[i], 0}); // 0 is curr index of element of nums1
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty() && k > 0) {
            List<Integer> pair = new ArrayList<>();
            int[] top = pq.poll();
            pair.add(top[0]);
            pair.add(top[1]);
            ans.add(pair);
            k--;

            if (top[2] + 1 == m) continue;
            
            int curr = top[2] + 1; // keep track curr element in nums1 and add next element and its index to the queue
            top[2] = curr;
            top[0] = nums1[curr]; 
            pq.offer(top);
        }

        return ans;
    }
}