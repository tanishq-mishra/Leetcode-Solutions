class Solution {
    int extractNumber(char a, char b) {
        int first = 0;
        int second = 0;
        
        char[] romans = new char[]{'I','V','X', 'L', 'C','D','M'};
        
        for(int i = 0; i<romans.length; i++) {
            if(romans[i] == a) {
                first = i;
            }
            if(romans[i] == b) {
                second = i;
            }
        }
        
        return first-second;
        
    }
    public int romanToInt(String s) {
        int number = 0;
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        for(int i = s.length()-1 ; i>=0 ; i--) {
            int temp = romanMap.get(s.charAt(i));
            while(i-1>=0 && s.charAt(i) == s.charAt(i-1)) {
                i--;
                temp+=romanMap.get(s.charAt(i));
            }
            
            if(temp > number) {
                number += temp;
            }
            else {
                number = number-temp;
            }
        }
        
        
        return number;
        
    }
}