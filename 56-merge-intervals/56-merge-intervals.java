
import java.util.*;   
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        ArrayList<int[]> inputList = new ArrayList<>();
        
        int[] newInterval = intervals[0];
        inputList.add(newInterval);
        for(int[] in: intervals) {
            if(in[0] <= newInterval[1]) {
                newInterval[1] = Math.max(in[1],newInterval[1]);
            } else {
                newInterval = in;
                inputList.add(newInterval);
            }
        }
        
        return  inputList.toArray(new int[inputList.size()][]);
    }
}