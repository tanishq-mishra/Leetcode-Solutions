class Solution {
    public static boolean isNumeric(String str) {
      return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
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
            //System.out.println(stack);
            if(isNumeric(t)) {
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