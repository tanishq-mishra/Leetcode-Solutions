class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        if(rowIndex == 0) {
            return prev;
        }
        prev.add(1);
        if(rowIndex == 1) {
            return prev;
        }
        
        
        
        int counter = 1;
        while(counter < rowIndex) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int i = 0; i<prev.size()-1; i++) {
                current.add(prev.get(i) + prev.get(i+1));
            }
            
            current.add(1);
            prev = current;
            
            counter++;
        }
        
        
        return prev;
        
        
    }
}