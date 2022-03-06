
import java.util.*;   
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        ArrayList<int[]> inputList = new ArrayList<>();
        for(int i = 0 ; i< intervals.length; i++) {
            int [] newInterval = new int [2];
            newInterval[0] = (intervals[i][0]);
            newInterval[1] = (intervals[i][1]);
            inputList.add(newInterval);
        }  
        int i = 0;
        while(i< inputList.size()) {
            if(i < inputList.size()-1 && inputList.get(i+1)[0] <= inputList.get(i)[1]) {
                int [] newInterval = new int [2];
                newInterval[0] = inputList.get(i)[0];
                newInterval[1] = Math.max(inputList.get(i)[1],inputList.get(i+1)[1]);
                inputList.set(i, newInterval);
                inputList.remove(i+1);
            } else {
                i++;
            }
        }
        
        // int[][] ans = new int[inputList.size()][2];
        // i = 0;
        // for(ArrayList<Integer> a: inputList) {
        //     ans[i][0] = a.get(0);
        //     ans[i++][1] = a.get(1);
        // }
        
        return  inputList.toArray(new int[inputList.size()][]);
    }
}