//replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1

import java.util.Arrays;

class Solution {
    public int[] replaceElements(int[] arr) {

        int maxVal = -1;
        
        for (int i = arr.length - 1; i >= 0 ; i-- ){
            // store currVal as will be replace by maxValue in next line
            int currVal = arr[i];
            arr[i] = maxVal;
            // get max of currVal and previous maxValue
            maxVal = Math.max(arr[i], currVal);

        }
        return arr;
        
    }
}
public class ReplaceElementsWithGreatestElementOnRightSide {
    
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(solution.replaceElements(arr)));
    }
}
