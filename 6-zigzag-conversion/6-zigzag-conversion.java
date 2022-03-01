class Solution {
    public String convert(String s, int numRows) {
        String[] rows = new String[numRows];
        
        int i = 0;
        int size = s.length();
        
        while(i < size) {
            int pos = i;
            for(int j = 0; j<numRows && (pos+j)<size; j++) {
                if(rows[j] == null) {
                    rows[j] = "" + s.charAt(pos+j);
                } else {
                    rows[j] = rows[j] + s.charAt(pos+j);
                }
                
            }
            pos +=numRows ;
            for(int j = numRows-2 ; j>0 && pos<size; j-- ) {
                rows[j] += s.charAt(pos++);
            }
            
            i = pos ;
        }
        
        String ans = "";
        
        for(String st: rows) {
            if(st != null)
                ans +=st;
        }
        
        return ans;
        
        
    }
}