class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int sellPrice = prices[prices.length - 1];
        for (int i = prices.length - 2;i >= 0;i--){
            int buyPrice = prices[i];

            int profit = sellPrice - buyPrice;
            if (profit > maxProfit){
                maxProfit = profit;
            }
            // replace sellPrice with the max value
            sellPrice = Math.max(sellPrice, buyPrice);
        }
        return maxProfit;
        
    }
}

public class BestTimeToBuySellStock {
    public static void main(String[] args){
        int[] prices = {7,6,4,3,1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }    
}
