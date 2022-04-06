class Solution {
    public int evaluate (int exp1, int exp2, String op) {
        if(op.equals("+"))
            return exp1 + exp2;
        if(op.equals("-"))
            return exp1 - exp2;
        if(op.equals("*"))
            return exp1 * exp2;
        if(op.equals("/"))
            return exp1 / exp2;
        return 0;
    }
    public int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();
        
        for(String t: tokens) {
            if(!t.equals("+") && !t.equals("-") && !t.equals("/") && !t.equals("*")) {
                stack.add(Integer.parseInt(t));
            } else {
                int exp2 = stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                
                int exp1 = stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                
                int newExp = evaluate(exp1, exp2, t);
                stack.add(newExp);
                
            }
        }
        
        
        return stack.get(stack.size()-1);
    }
}