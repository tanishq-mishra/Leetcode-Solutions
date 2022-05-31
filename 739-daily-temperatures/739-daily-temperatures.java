class Solution {
    
    static class StackEntry {
        int index;
        int value;
        
        StackEntry(int i, int v) {
            index = i;
            value = v;
        }
    }
    
    
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        List<StackEntry> stack = new ArrayList<>();
        
        for(int i = 0; i<temperatures.length; i++) {
            while(stack.size() != 0 && stack.get(stack.size()-1).value < temperatures[i]) {
                StackEntry temp = stack.get(stack.size()-1);
                res[temp.index] = i - temp.index;
                stack.remove(stack.size()-1);
            }
            StackEntry newTemp = new StackEntry(i, temperatures[i]);
            
            stack.add(newTemp);
        }
        
        
        return res;
    }
}