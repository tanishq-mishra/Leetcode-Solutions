class Solution {
    
    public int eraseOverlapIntervals(int[][] intervals) {  
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]) != 0 ? Integer.compare(i1[0], i2[0]) : Integer.compare(i1[1], i2[1]));
        int counter = 0;
        boolean removedLast = false;
        int maxLast = intervals[0][1];
        int minLast = 0;
        for(int i = 0; i < intervals.length -1; i++) {
            // System.out.println(intervals[i][0] + " " + intervals[i][1]);
            // System.out.println(intervals[i+1][0] + " " +intervals[i+1][1]);
            // System.out.println("maxLast" + maxLast);
            if(intervals[i][1] > intervals[i+1][0]) {
                System.out.println("First True");
                if(maxLast > intervals[i+1][0]) {
                    //System.out.println("Second True");
                    maxLast = Math.min(intervals[i+1][1], maxLast);
                    counter++;
                    removedLast = true;

                } else if(removedLast) {
                    maxLast = intervals[i+1][1];
                    removedLast = false;
                }
                
            } else {
                maxLast = intervals[i+1][1] ;
            }
        }
        
        return counter;
        
    }
}

