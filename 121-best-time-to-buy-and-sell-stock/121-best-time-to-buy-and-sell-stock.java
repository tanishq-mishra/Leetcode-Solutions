// SLIDING WINDOW PROBLEM

// class Solution {
//     public int maxProfit(int[] prices) {
//         int minPrice = Integer.MAX_VALUE;
//         int maxProfit = 0;
        
//         for(int i = 0 ; i<prices.length; i++) {
//             if(prices[i] < minPrice) {
//                 minPrice = prices[i];
//             } else if((prices[i] - minPrice) > maxProfit) {
//                 maxProfit = (prices[i] - minPrice);
//             }
//         }
        
//         return maxProfit;
//     }
// }


class Solution {
    public int maxProfit(int[] prices) {
        int left =0;
        int right = 1;
        int profit = 0;
        
        while(right< prices.length) {
            if(prices[left] < prices[right]) {
                profit = Math.max(profit, prices[right]-prices[left]);
                right++;
            } else {
                left = right;
                right++;
            }
        }
        
        return profit;
    }
}