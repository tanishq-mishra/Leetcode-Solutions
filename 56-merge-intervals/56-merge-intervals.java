
import java.util.*;   
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        ArrayList<ArrayList<Integer>> inputList = new ArrayList<>();
        for(int i = 0 ; i< intervals.length; i++) {
            ArrayList<Integer> newInterval = new ArrayList<>();
            newInterval.add(intervals[i][0]);
            newInterval.add(intervals[i][1]);
            inputList.add(newInterval);
        }
        // Collections.sort(inputList, new Comparator<ArrayList<Integer>>() {
        //     @Override
        //     public int compare(ArrayList<Integer> one, ArrayList<Integer> two) {
        //         if(one.get(0) > two.get(0)) {
        //             return 1;
        //         } else if(one.get(0) < two.get(0)) {
        //             return -1;
        //         }
        //         return 0;
        //     }
        // });   
        int i = 0;
        while(i< inputList.size()) {
            if(i < inputList.size()-1 && inputList.get(i+1).get(0) <= inputList.get(i).get(1)) {
                ArrayList<Integer> newInterval = new ArrayList<>();
                newInterval.add(Math.min(inputList.get(i).get(0),inputList.get(i+1).get(0)) );
                newInterval.add(Math.max(inputList.get(i).get(1),inputList.get(i+1).get(1)) );
                inputList.set(i, newInterval);
                inputList.remove(i+1);
            } else {
                i++;
            }
        }
        
        int[][] ans = new int[inputList.size()][2];
        i = 0;
        for(ArrayList<Integer> a: inputList) {
            ans[i][0] = a.get(0);
            ans[i++][1] = a.get(1);
        }
        
        return ans;
    }
}