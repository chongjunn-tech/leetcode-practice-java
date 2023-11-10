import java.util.Arrays;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n];
        // initialization of minCost Array
        // cost.length >= 2
        // can either start from 0 or 1
        minCost[0] = cost[0];
        minCost[1] = cost[1];

        for (int i = 2; i < n; i++){
            minCost[i] = Math.min(minCost[i-1], minCost[i -2]) + cost[i];
        }

        // since can climb one or two steps: get last or second last (min)
        return Math.min(minCost[n-1],minCost[n-2]);

    }
}

public class MinCostClimbingStairs {
    public static void main(String[] args){
        
        Solution solution = new Solution();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        // int[] cost = {10, 15 ,20};
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
