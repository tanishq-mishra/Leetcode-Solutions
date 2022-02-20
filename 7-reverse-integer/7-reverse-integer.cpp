class Solution {
public:
    int reverse(long long int x) {
        bool isNegative = false;
        long long int reverse = 0;
        if(x < 0) {
            isNegative = true;
            x *= -1;
        }
        
        while(x > 0) {
            int digit = x%10;
            
            reverse = reverse*10 + digit;
            if(reverse > INT_MAX) {
                return 0;
            }
            x /=10;
        } 
        
        if(isNegative) {
            reverse *= -1;
        }
        
        return reverse;
        
    }
};