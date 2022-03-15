// class Solution {
    
//     public int eraseOverlapIntervals(int[][] intervals) {  
//         Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
//         int counter = 0;
//         boolean removedLast = false;
//         int maxLast = intervals[0][1];
//         for(int i = 0; i < intervals.length -1; i++) {
//             if(intervals[i][1] > intervals[i+1][0]) {
//                 if(maxLast > intervals[i+1][0]) {
//                     maxLast = Math.min(intervals[i+1][1], maxLast);
//                     counter++;
//                     removedLast = true;

//                 } else if(removedLast) {
//                     maxLast = intervals[i+1][1];
//                     removedLast = false;
//                 }
                
//             } else {
//                 maxLast = intervals[i+1][1] ;
//             }
//         }
//         return counter;
//     }
// }



class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int count = 0;
        int end = intervals[0][0];
        
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        
        return count;
    }
}