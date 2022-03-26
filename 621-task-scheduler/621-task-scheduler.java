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
        Queue<List<Integer>> runningQueue = new LinkedList<>();

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
                if(runningQueue.peek().get(1) == time) {
                    pq.add(runningQueue.poll().get(0));
                }
            }
            
            
        }
        return time;
    }
}