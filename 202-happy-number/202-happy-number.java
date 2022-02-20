class Solution {
    
    public ArrayList<Integer> getDigits(int n) {
        int numberOfDigits = (int)Math.floor(Math.log10(n) + 1);
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int i =0;
        while(i < numberOfDigits) {
            int temp = n % 10;
            n = n/10;
            digits.add(temp);
            i++;
            
        }
        
        return digits;
    }
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while(n != 1) {
            ArrayList<Integer> digits = getDigits(n);
            //System.out.println(digits);
            int product = 0;
            
            for(int d: digits) {
                product = product + (d*d);
                
            }
            //System.out.println(product);
            if(product == 1) {
                return true;
            }
            
            if(seen.contains(product)) {
                return false;
            }
            seen.add(product);
            
            n = product;
        }
        
        return true;
    }
}