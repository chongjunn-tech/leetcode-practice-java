import java.util.Arrays;

class SolutionNaive {
    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        for (int p1 = 0; p1 < numbers.length - 1; p1++){

            for (int p2 = p1 + 1 ; p2 < numbers.length; p2++){

                int num1 = numbers[p1];
                int num2 = numbers[p2];
                
                System.out.println("num1:" + num1 +"num2:" +num2);
                if (num1 + num2 == target){
                    System.out.println("results-->num1:" + num1 +"num2:" +num2);
                    results[0] = p1 + 1;
                    results[1] = p2 + 1;
                    return results;
                }

            }
        }
        return results;

    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];

        int l = 0;
        int r = numbers.length - 1;


        // numbers are sorted in non-decreasing order
        // exactly one solution
        // so can have 2 pointers: if lesser than target then increase leftpointer
        // if more than target, then reduce rightpointer
        while (l < r){
            
            int add = numbers[l] + numbers[r];
  
            if (add == target){
                results[0] = l + 1;
                results[1] = r + 1;
                return results;
            }
            else if (add > target){
                r--;
            }
            else if (add < target){
                l++;
            }
        }
        return results;

    }
}
public class TwoSum {
    public static void main(String[] args){
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(numbers, target)));
    }   
}
