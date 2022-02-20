class Solution {
    public int getProduct(int n) {
        int product = 0;
        
        while(n > 0) {
            int temp = n %10;
            product = product + (temp*temp);
            n = n/10;
        }
        
        return product;
    }
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while(n != 1) {
            //ArrayList<Integer> digits = getDigits(n);
            //System.out.println(digits);
            int product = getProduct(n);
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