class MinStack {
    List<Integer> stack;
    List<Integer> minIndexList;
    public MinStack() {
        stack = new ArrayList<>();
        minIndexList = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(stack.size() == 1) {
            minIndexList.add(0);
        } else if(stack.get(stack.size() -1) < stack.get(minIndexList.get(minIndexList.size()-1))) {
            minIndexList.add(stack.size()-1);
            
        }
    }
    
    public void pop() {
        int index = stack.size()-1;
        stack.remove(index); 
        if(minIndexList.get(minIndexList.size()-1) == index) {
            minIndexList.remove(minIndexList.size()-1);
        }
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return stack.get(minIndexList.get(minIndexList.size()-1));
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */