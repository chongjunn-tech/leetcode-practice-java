import java.util.Arrays;

class Solution{
    public void moveZeroes(int[] nums){
        // go through the array and gather all 0s on the road
        int snowballSize = 0;

        for (int i = 0; i < nums.length ;i++){
            
            int num = nums[i];

            // increase the snowball if num ==0
            if (num == 0){
                snowballSize++;
            }
            else{

                if (snowballSize > 0){
                    //swap 1st element with the last element
                    nums[i - snowballSize] = num;
                    nums[i] = 0;
                }
            }

        }
        

    }
}
public class MoveZeroes {
    public static void main(String[] args){

        Solution solution = new Solution();

        int[] nums = {0, 1, 0, 3 ,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
