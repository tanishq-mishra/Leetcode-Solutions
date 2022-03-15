
import java.util.*;   
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        
        
        for(int[] in: intervals) {
            if(in[0] <= newInterval[1]) {
                newInterval[1] = Math.max(in[1],newInterval[1]);
            } else {
                newInterval = in;
                ans.add(newInterval);
            }
        }
        
        return  ans.toArray(new int[ans.size()][]);
    }
}