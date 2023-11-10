import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];

        int count = 1;
        for (int i = 1;i < nums.length ;i++){
            int num = nums[i];

            if (count == 0){
                ele = nums[i];
                count++;
            }
            if (num == ele){
                count++;
            }
            else{
                count--;
            }
        }
        return ele;
    }
}

public class Main{
    public static void main(String args[]){
        Solution s = new Solution();

        int nums [] = {2,2,1,1,1,2,2};
        System.out.println(s.majorityElement(nums));

  
    }
}