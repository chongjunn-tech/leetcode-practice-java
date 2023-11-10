import java.util.ArrayList;
import java.lang.Math;
class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        ways[0] = 0;
        ways[1] = 1;

        if (n >= 2){
            ways[2] = 2;
            for (int i = 3;i <= n;i++){
                ways[i] = ways[i-1] + ways[i-2];
            }
        }
        
        return ways[n];
    }
}

public class ClimbingStairs {
    public static void main(String args[]){
        int n = 2;
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(n));
    }
    
}
