class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> subSequences = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]) {
                // greedily prioritize shorter length
                int l1 = a[1]-a[0] + 1;
                int l2 = b[1]-b[0] + 1;
                return Integer.compare(l1, l2);
            }
            
            return Integer.compare(a[1],b[1]);
        });
        
        
        
        for(int i: nums) {
            //System.out.println(subSequences);
            while(!subSequences.isEmpty() && subSequences.peek()[1]+1 < i) {
                if(subSequences.peek()[1] - subSequences.peek()[0]+1 < 3) {
                    return false;
                } 
                subSequences.poll();
            }
            if(subSequences.isEmpty()|| subSequences.peek()[1] == i) {
                int[] newSeq = new int[2];
                newSeq[0] = i;
                newSeq[1] = i;
                subSequences.offer(newSeq);
            } else {
                int[] seq = subSequences.poll();
                seq[1] = i;
                subSequences.add(seq);
            }
        }
        
        for(int[] seq : subSequences) {
            if(seq[1] - seq[0]+1 <3) {
                return false;
            }
        }
        
        
        return true;
        
    }
}