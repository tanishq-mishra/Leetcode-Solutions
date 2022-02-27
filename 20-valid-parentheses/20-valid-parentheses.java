class Solution {
    public boolean isValid(String x) {
        Stack<Character> st = new Stack<>();
        for(int i =0; i< x.length(); i++) {
            char c = x.charAt(i);
            if(c == '(' || c == '['||c == '{') {
                st.push(c);
            } else {
                if(st.empty()) {
                    return false;
                }
                if(c == ')') {
                    char popped = st.pop();
                    if(popped != '(')
                        return false;
                }
                if(c == ']') {
                    char popped = st.pop();
                    if(popped != '[')
                        return false;
                }
                if(c == '}') {
                    char popped = st.pop();
                    if(popped != '{')
                        return false;
                }
            }
        }
        
        if(st.empty()) {
            return true;
        }
        
        return false;
    }
}