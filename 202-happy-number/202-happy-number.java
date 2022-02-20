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
//     public boolean isHappy(int n) {
//         Set<Integer> seen = new HashSet<>();
        
//         while(n != 1 && !seen.contains(n)) {
//             seen.add(n);
//             n = getProduct(n);
//         }
        
//         return n == 1;
//     }
    
    
    // Using Fast and Slow Pointer Method
    
    public boolean isHappy (int n) {
        int fast = n;
        int slow = n;
        do {
            fast = getProduct(getProduct(fast));
            slow = getProduct(slow);
        }
        while(fast != slow);
        
        return slow == 1;
    }
}