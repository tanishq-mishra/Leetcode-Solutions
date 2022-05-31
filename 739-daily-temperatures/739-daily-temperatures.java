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
        Stack<StackEntry> stack = new Stack<>();
        
        for(int i = 0; i<temperatures.length; i++) {
            while(stack.size() != 0 && stack.peek().value < temperatures[i]) {
                StackEntry temp = stack.pop();
                res[temp.index] = i - temp.index;
                //stack.pop();
            }
            StackEntry newTemp = new StackEntry(i, temperatures[i]);
            
            stack.push(newTemp);
        }
        
        
        return res;
    }
}