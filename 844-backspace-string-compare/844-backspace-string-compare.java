class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        for(int i = 0 ; i<s.length(); i++) {
            if(s.charAt(i) != '#') {
                s1.push(s.charAt(i));
            } else {
                if(!s1.empty())
                    s1.pop();
            }
        }
        for(int i = 0 ; i<t.length(); i++) {
            if(t.charAt(i) != '#') {
                s2.push(t.charAt(i));
            } else {
                if(!s2.empty())
                    s2.pop();
            }
        }
        
        while(!s1.empty()) {
            if(s2.empty())
                return false;
            char a = s1.pop();
            char b = s2.pop();
            
            if(a != b) {
                return false;
            }
        }
        
        if(!s2.empty()) {
            return false;
        }
        
        return true;
    }
}