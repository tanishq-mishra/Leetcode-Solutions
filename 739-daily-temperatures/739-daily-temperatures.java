class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        List<List<Integer>> stack = new ArrayList<>();
        
        for(int i = 0; i<temperatures.length; i++) {
            while(stack.size() != 0 && stack.get(stack.size()-1).get(1) < temperatures[i]) {
                List<Integer> temp = stack.get(stack.size()-1);
                res[temp.get(0)] = i - temp.get(0);
                stack.remove(stack.size()-1);
            }
            List<Integer> newTemp = new ArrayList<Integer>();
            newTemp.add(i);
            newTemp.add(temperatures[i]);
            stack.add(newTemp);
        }
        
        
        return res;
    }
}