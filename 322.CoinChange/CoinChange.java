import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinsCount = new int[amount + 1];

        coinsCount[0] = 0;
        for (int i = 1; i <=amount ;i++){
            
            for (int coin:coins){
                int diff = i - coin;
                // exactly 0 -> is the coin
                if (diff == 0){
                    coinsCount[i] = 1;
                }
                // difference is positive-> may be possible
                // and coinsCount[diff] not 0
                else if (diff > 0 && coinsCount[diff] != 0 ){
                    int count = coinsCount[diff] + 1;
                    // if equal to 0, then assign to count
                    // if not find the minimum
                    if (coinsCount[i] == 0) coinsCount[i] = count;
                    else coinsCount[i] = Math.min(count, coinsCount[i]);
                    
                    
                }
                
                }
            }
        
        System.out.println(Arrays.toString(coinsCount));
        if (amount == 0){
            return 0;
        }
        return (coinsCount[amount] == 0)? -1:coinsCount[amount];
        
    }
}
public class CoinChange {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] coins = {1};
        int amount = 0;
        System.out.println(solution.coinChange(coins, amount));
    }
}


// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104