class Solution {
    public int leastInterval(char[] tasks, int n) {
        // No cool down time, the tasks can run in any sequence witout any idle time.
        if(n == 0) {
            return tasks.length;
        }
        
        
        Map<Character, Integer> hm = new HashMap<>(); 
        for(char t : tasks) {
            hm.put(t, hm.getOrDefault(t, 0) +1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Map.Entry<Character, Integer> e : hm.entrySet()) {
            pq.add(e.getValue());
        } 

        int time = 0;
        List<List<Integer>> runningQueue = new ArrayList<>();

        while(!pq.isEmpty() || !runningQueue.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                int currentTask = pq.poll();
                
                currentTask--;

                if(currentTask != 0) {
                    List<Integer> runningTask = new ArrayList<>();
                    runningTask.add(currentTask);
                    runningTask.add(time + n);
                    runningQueue.add(runningTask);
                }
            }
            if(!runningQueue.isEmpty()) {
                if(runningQueue.get(0).get(1) == time) {
                    pq.add(runningQueue.get(0).get(0));
                    runningQueue.remove(0);
                }
            }
            
            
        }
        return time;
    }
}